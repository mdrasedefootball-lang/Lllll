package com.example.data

import androidx.compose.ui.graphics.Color
import com.example.data.books.getBook1Fairies
import com.example.data.books.getBook2Unicorns
import com.example.data.books.getBook3Dragons
import com.example.data.books.getBook4Animals
import com.example.data.models.ColoringBook
import com.example.data.models.PaletteColor

object ColoringRepository {
    val books: List<ColoringBook> by lazy {
        listOf(
            getBook1Fairies(),
            getBook2Unicorns(),
            getBook3Dragons(),
            getBook4Animals()
        )
    }

    /**
     * 24 kid-friendly vibrant colors as specified in requirements
     */
    val paletteColors: List<PaletteColor> = listOf(
        PaletteColor("Red", Color(0xFFFF3B30)),
        PaletteColor("Orange", Color(0xFFFF9500)),
        PaletteColor("Yellow", Color(0xFFFFCC00)),
        PaletteColor("Green", Color(0xFF34C759)),
        PaletteColor("Light Green", Color(0xFF8CE642)),
        PaletteColor("Cyan", Color(0xFF00D1FF)),
        PaletteColor("Blue", Color(0xFF007AFF)),
        PaletteColor("Dark Blue", Color(0xFF0A387E)),
        PaletteColor("Purple", Color(0xFFAF52DE)),
        PaletteColor("Pink", Color(0xFFFF2D55)),
        PaletteColor("Hot Pink", Color(0xFFFF1493)),
        PaletteColor("Brown", Color(0xFF8B4513)),
        PaletteColor("Beige", Color(0xFFF5F5DC)),
        PaletteColor("Peach", Color(0xFFFFDAB9)),
        PaletteColor("Skin Tone 1", Color(0xFFFFDFC4)),
        PaletteColor("Skin Tone 2", Color(0xFF8D5524)),
        PaletteColor("Light Gray", Color(0xFFD3D3D3)),
        PaletteColor("Dark Gray", Color(0xFF555555)),
        PaletteColor("Black", Color(0xFF000000)),
        PaletteColor("White", Color(0xFFFFFFFF)),
        PaletteColor("Lavender", Color(0xFFE6E6FA)),
        PaletteColor("Mint", Color(0xFF98FF98)),
        PaletteColor("Neon Green", Color(0xFF39FF14)),
        PaletteColor("Neon Pink", Color(0xFFFF6EC7))
    )
}
