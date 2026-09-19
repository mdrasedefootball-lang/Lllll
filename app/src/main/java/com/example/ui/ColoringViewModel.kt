package com.example.ui

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.ColoringRepository
import com.example.data.models.ColorAction
import com.example.data.models.ColoringBook
import com.example.data.models.ColoringPage
import com.example.engine.VectorColoringEngine
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

data class SparkleEvent(
    val x: Float,
    val y: Float,
    val color: Color,
    val id: Long = System.currentTimeMillis()
)

class ColoringViewModel : ViewModel() {

    private val books = ColoringRepository.books

    private val _currentBook = MutableStateFlow(books.first())
    val currentBook: StateFlow<ColoringBook> = _currentBook.asStateFlow()

    private val _currentPage = MutableStateFlow(books.first().pages.first())
    val currentPage: StateFlow<ColoringPage> = _currentPage.asStateFlow()

    var engine: VectorColoringEngine = VectorColoringEngine(_currentPage.value)
        private set

    private val _currentColor = MutableStateFlow(ColoringRepository.paletteColors.first().color)
    val currentColor: StateFlow<Color> = _currentColor.asStateFlow()

    // Page-specific fills: map of pageId -> (regionId -> Color)
    private val pageFillsCache = mutableMapOf<String, MutableMap<String, Color>>()

    private val _appliedFills = MutableStateFlow<Map<String, Color>>(emptyMap())
    val appliedFills: StateFlow<Map<String, Color>> = _appliedFills.asStateFlow()

    // Undo / Redo stacks
    private val undoStack = mutableListOf<ColorAction>()
    private val redoStack = mutableListOf<ColorAction>()

    private val _canUndo = MutableStateFlow(false)
    val canUndo: StateFlow<Boolean> = _canUndo.asStateFlow()

    private val _canRedo = MutableStateFlow(false)
    val canRedo: StateFlow<Boolean> = _canRedo.asStateFlow()

    // Zoom and Pan
    private val _zoomScale = MutableStateFlow(1.0f)
    val zoomScale: StateFlow<Float> = _zoomScale.asStateFlow()

    private val _panOffset = MutableStateFlow(Offset.Zero)
    val panOffset: StateFlow<Offset> = _panOffset.asStateFlow()

    // Dialog & Feedback States
    private val _sparkle = MutableStateFlow<SparkleEvent?>(null)
    val sparkle: StateFlow<SparkleEvent?> = _sparkle.asStateFlow()

    private val _showClearConfirm = MutableStateFlow(false)
    val showClearConfirm: StateFlow<Boolean> = _showClearConfirm.asStateFlow()

    private val _savedBitmap = MutableStateFlow<Bitmap?>(null)
    val savedBitmap: StateFlow<Bitmap?> = _savedBitmap.asStateFlow()

    private val _savedUri = MutableStateFlow<Uri?>(null)
    val savedUri: StateFlow<Uri?> = _savedUri.asStateFlow()

    private val _isSaving = MutableStateFlow(false)
    val isSaving: StateFlow<Boolean> = _isSaving.asStateFlow()

    init {
        loadPageFills(_currentPage.value.id)
    }

    fun selectBook(book: ColoringBook) {
        if (_currentBook.value.id == book.id) return
        _currentBook.value = book
        selectPage(book.pages.first())
    }

    fun selectPage(page: ColoringPage) {
        if (_currentPage.value.id == page.id) return
        // Save current page fills
        pageFillsCache[_currentPage.value.id] = _appliedFills.value.toMutableMap()

        _currentPage.value = page
        engine = VectorColoringEngine(page)
        loadPageFills(page.id)
        undoStack.clear()
        redoStack.clear()
        updateUndoRedoStates()
        resetView()
    }

    private fun loadPageFills(pageId: String) {
        val cached = pageFillsCache[pageId] ?: mutableMapOf()
        _appliedFills.value = cached.toMap()
    }

    fun selectColor(color: Color) {
        _currentColor.value = color
    }

    /**
     * Taps a coordinate on the SVG viewport (0..600).
     */
    fun handleRegionTap(svgX: Float, svgY: Float, canvasX: Float, canvasY: Float) {
        val targetRegion = engine.findRegionAt(svgX, svgY) ?: return
        val currentFill = _appliedFills.value[targetRegion.id] ?: targetRegion.defaultFill
        val newFill = _currentColor.value

        if (currentFill == newFill) return

        // Record undo action
        undoStack.add(ColorAction(targetRegion.id, currentFill, newFill))
        redoStack.clear()
        updateUndoRedoStates()

        // Apply fill
        val updated = _appliedFills.value.toMutableMap()
        updated[targetRegion.id] = newFill
        _appliedFills.value = updated
        pageFillsCache[_currentPage.value.id] = updated

        // Trigger visual sparkle effect
        _sparkle.value = SparkleEvent(canvasX, canvasY, newFill)
    }

    fun clearSparkle() {
        _sparkle.value = null
    }

    fun undo() {
        if (undoStack.isEmpty()) return
        val action = undoStack.removeAt(undoStack.lastIndex)
        redoStack.add(action)
        updateUndoRedoStates()

        val updated = _appliedFills.value.toMutableMap()
        if (action.previousColor == Color.White) {
            updated.remove(action.regionId)
        } else {
            updated[action.regionId] = action.previousColor
        }
        _appliedFills.value = updated
        pageFillsCache[_currentPage.value.id] = updated
    }

    fun redo() {
        if (redoStack.isEmpty()) return
        val action = redoStack.removeAt(redoStack.lastIndex)
        undoStack.add(action)
        updateUndoRedoStates()

        val updated = _appliedFills.value.toMutableMap()
        updated[action.regionId] = action.newColor
        _appliedFills.value = updated
        pageFillsCache[_currentPage.value.id] = updated
    }

    private fun updateUndoRedoStates() {
        _canUndo.value = undoStack.isNotEmpty()
        _canRedo.value = redoStack.isNotEmpty()
    }

    fun askClearCurrentPage() {
        _showClearConfirm.value = true
    }

    fun dismissClearConfirm() {
        _showClearConfirm.value = false
    }

    fun confirmClearCurrentPage() {
        _appliedFills.value = emptyMap()
        pageFillsCache[_currentPage.value.id]?.clear()
        undoStack.clear()
        redoStack.clear()
        updateUndoRedoStates()
        _showClearConfirm.value = false
    }

    fun zoomIn() {
        _zoomScale.value = (_zoomScale.value + 0.35f).coerceAtMost(4.0f)
    }

    fun zoomOut() {
        _zoomScale.value = (_zoomScale.value - 0.35f).coerceAtLeast(0.8f)
    }

    fun resetView() {
        _zoomScale.value = 1.0f
        _panOffset.value = Offset.Zero
    }

    fun updatePanAndZoom(zoomChange: Float, panChange: Offset) {
        val newScale = (_zoomScale.value * zoomChange).coerceIn(0.8f, 4.0f)
        _zoomScale.value = newScale
        _panOffset.value = _panOffset.value + panChange
    }

    fun saveMasterpiece(context: Context) {
        viewModelScope.launch {
            _isSaving.value = true
            try {
                val bitmap = engine.exportToBitmap(_appliedFills.value, 1200, 1200)
                val uri = saveBitmapToGallery(context, bitmap, "masterpiece-${System.currentTimeMillis()}")
                _savedUri.value = uri
                _savedBitmap.value = bitmap
            } catch (e: Exception) {
                // In case saving fails, still provide bitmap for preview
                val bitmap = engine.exportToBitmap(_appliedFills.value, 1200, 1200)
                _savedBitmap.value = bitmap
            } finally {
                _isSaving.value = false
            }
        }
    }

    fun dismissSaveDialog() {
        _savedBitmap.value = null
        _savedUri.value = null
    }

    private fun saveBitmapToGallery(context: Context, bitmap: Bitmap, filename: String): Uri? {
        val resolver = context.contentResolver
        val imageUri: Uri?
        val outputStream: OutputStream?

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val contentValues = ContentValues().apply {
                put(MediaStore.MediaColumns.DISPLAY_NAME, "$filename.png")
                put(MediaStore.MediaColumns.MIME_TYPE, "image/png")
                put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES + "/ColoringStudio")
            }
            imageUri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
            outputStream = imageUri?.let { resolver.openOutputStream(it) }
        } else {
            val imagesDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString() + "/ColoringStudio"
            val dir = File(imagesDir)
            if (!dir.exists()) dir.mkdirs()
            val image = File(dir, "$filename.png")
            outputStream = FileOutputStream(image)
            imageUri = Uri.fromFile(image)
        }

        outputStream?.use {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, it)
        }

        return imageUri
    }

    fun getPageCompletionPercent(pageId: String): Int {
        val fills = pageFillsCache[pageId] ?: if (_currentPage.value.id == pageId) _appliedFills.value else emptyMap()
        val page = _currentBook.value.pages.find { it.id == pageId } ?: return 0
        if (page.regions.isEmpty()) return 0
        val coloredCount = fills.count { it.value != Color.White }
        return ((coloredCount.toFloat() / page.regions.size.toFloat()) * 100).toInt().coerceIn(0, 100)
    }
}
