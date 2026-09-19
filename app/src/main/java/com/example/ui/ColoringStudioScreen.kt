package com.example.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.components.BookAndPageSelector
import com.example.ui.components.CanvasControlsBar
import com.example.ui.components.ClearConfirmDialog
import com.example.ui.components.ColorPaletteBar
import com.example.ui.components.ColoringCanvas
import com.example.ui.components.SaveMasterpieceDialog

@Composable
fun ColoringStudioScreen(
    viewModel: ColoringViewModel = viewModel()
) {
    val context = LocalContext.current

    val currentBook by viewModel.currentBook.collectAsState()
    val currentPage by viewModel.currentPage.collectAsState()
    val currentColor by viewModel.currentColor.collectAsState()
    val appliedFills by viewModel.appliedFills.collectAsState()

    val canUndo by viewModel.canUndo.collectAsState()
    val canRedo by viewModel.canRedo.collectAsState()

    val zoomScale by viewModel.zoomScale.collectAsState()
    val panOffset by viewModel.panOffset.collectAsState()
    val sparkleEvent by viewModel.sparkle.collectAsState()

    val showClearConfirm by viewModel.showClearConfirm.collectAsState()
    val savedBitmap by viewModel.savedBitmap.collectAsState()
    val savedUri by viewModel.savedUri.collectAsState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.statusBars)
            .windowInsetsPadding(WindowInsets.navigationBars),
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            val isLandscape = maxWidth > maxHeight && maxWidth > 700.dp

            if (isLandscape) {
                // Landscape / Tablet Split Layout
                Row(modifier = Modifier.fillMaxSize()) {
                    // Left Column: Canvas + Controls
                    Column(
                        modifier = Modifier
                            .weight(1.3f)
                            .fillMaxHeight()
                    ) {
                        StudioHeader(
                            bookTitle = currentBook.shortTitle,
                            pageTitle = currentPage.title,
                            accentColor = currentBook.accentColor
                        )

                        CanvasControlsBar(
                            canUndo = canUndo,
                            canRedo = canRedo,
                            onUndo = viewModel::undo,
                            onRedo = viewModel::redo,
                            onClear = viewModel::askClearCurrentPage,
                            onSave = { viewModel.saveMasterpiece(context) },
                            onZoomIn = viewModel::zoomIn,
                            onZoomOut = viewModel::zoomOut,
                            onResetView = viewModel::resetView
                        )

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth()
                        ) {
                            ColoringCanvas(
                                page = currentPage,
                                engine = viewModel.engine,
                                appliedFills = appliedFills,
                                zoomScale = zoomScale,
                                panOffset = panOffset,
                                sparkleEvent = sparkleEvent,
                                onRegionTap = viewModel::handleRegionTap,
                                onPanZoom = viewModel::updatePanAndZoom,
                                onDoubleTapReset = viewModel::resetView,
                                onSparkleComplete = viewModel::clearSparkle
                            )
                        }

                        ColorPaletteBar(
                            selectedColor = currentColor,
                            onColorSelected = viewModel::selectColor
                        )
                    }

                    // Right Column: Book and Page Selector
                    Surface(
                        modifier = Modifier
                            .weight(0.7f)
                            .fillMaxHeight(),
                        color = MaterialTheme.colorScheme.surface,
                        tonalElevation = 2.dp
                    ) {
                        BookAndPageSelector(
                            currentBook = currentBook,
                            currentPage = currentPage,
                            pageFills = appliedFills,
                            getCompletionPercent = viewModel::getPageCompletionPercent,
                            onSelectBook = viewModel::selectBook,
                            onSelectPage = viewModel::selectPage
                        )
                    }
                }
            } else {
                // Portrait Layout (Phone & Standard Tablet)
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    // Top: App Title & Active Page Info
                    StudioHeader(
                        bookTitle = currentBook.shortTitle,
                        pageTitle = currentPage.title,
                        accentColor = currentBook.accentColor
                    )

                    // Toolbar
                    CanvasControlsBar(
                        canUndo = canUndo,
                        canRedo = canRedo,
                        onUndo = viewModel::undo,
                        onRedo = viewModel::redo,
                        onClear = viewModel::askClearCurrentPage,
                        onSave = { viewModel.saveMasterpiece(context) },
                        onZoomIn = viewModel::zoomIn,
                        onZoomOut = viewModel::zoomOut,
                        onResetView = viewModel::resetView
                    )

                    // Center Canvas (fills remaining available space)
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                    ) {
                        ColoringCanvas(
                            page = currentPage,
                            engine = viewModel.engine,
                            appliedFills = appliedFills,
                            zoomScale = zoomScale,
                            panOffset = panOffset,
                            sparkleEvent = sparkleEvent,
                            onRegionTap = viewModel::handleRegionTap,
                            onPanZoom = viewModel::updatePanAndZoom,
                            onDoubleTapReset = viewModel::resetView,
                            onSparkleComplete = viewModel::clearSparkle
                        )
                    }

                    // Bottom Section: Color Palette + Book & Page Selector
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        ColorPaletteBar(
                            selectedColor = currentColor,
                            onColorSelected = viewModel::selectColor
                        )

                        BookAndPageSelector(
                            currentBook = currentBook,
                            currentPage = currentPage,
                            pageFills = appliedFills,
                            getCompletionPercent = viewModel::getPageCompletionPercent,
                            onSelectBook = viewModel::selectBook,
                            onSelectPage = viewModel::selectPage
                        )
                    }
                }
            }
        }
    }

    // Clear Confirmation Dialog
    if (showClearConfirm) {
        ClearConfirmDialog(
            onConfirm = viewModel::confirmClearCurrentPage,
            onDismiss = viewModel::dismissClearConfirm
        )
    }

    // Save Masterpiece Success Dialog
    if (savedBitmap != null) {
        SaveMasterpieceDialog(
            bitmap = savedBitmap,
            savedUri = savedUri,
            onDismiss = viewModel::dismissSaveDialog
        )
    }
}

@Composable
private fun StudioHeader(
    bookTitle: String,
    pageTitle: String,
    accentColor: Color
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp, vertical = 4.dp),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 1.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(34.dp)
                        .clip(CircleShape)
                        .background(
                            Brush.linearGradient(
                                listOf(accentColor, MaterialTheme.colorScheme.primary)
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Palette,
                        contentDescription = "Coloring Studio",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                Column {
                    Text(
                        text = "Kids Coloring Studio",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Black,
                            fontSize = 15.sp,
                            letterSpacing = 0.sp
                        ),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "$bookTitle • $pageTitle",
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        ),
                        maxLines = 1
                    )
                }
            }

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(accentColor.copy(alpha = 0.15f))
                    .padding(horizontal = 10.dp, vertical = 4.dp)
            ) {
                Text(
                    text = "Tap to Fill",
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontWeight = FontWeight.Bold,
                        color = accentColor
                    )
                )
            }
        }
    }
}
