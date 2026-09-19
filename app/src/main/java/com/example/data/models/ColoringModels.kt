package com.example.data.models

import androidx.compose.ui.graphics.Color

/**
 * Represents an individual colorable SVG vector path/region in a scene.
 */
data class ColorableRegion(
    val id: String,
    val name: String,
    val pathData: String,
    val defaultFill: Color = Color.White,
    val strokeColor: Color = Color.Black,
    val strokeWidth: Float = 4.5f,
    val zIndex: Int = 0 // Higher zIndex draws outlines on top, or can be hit-tested first
)

/**
 * Represents a single coloring page scene.
 */
data class ColoringPage(
    val id: String,
    val title: String,
    val subtitle: String,
    val viewBoxWidth: Float = 600f,
    val viewBoxHeight: Float = 600f,
    val regions: List<ColorableRegion>
)

/**
 * Represents a major coloring book theme.
 */
data class ColoringBook(
    val id: String,
    val title: String,
    val shortTitle: String,
    val iconName: String,
    val accentColor: Color,
    val pages: List<ColoringPage>
)

/**
 * Action record for undo/redo history.
 */
data class ColorAction(
    val regionId: String,
    val previousColor: Color,
    val newColor: Color
)

/**
 * Color palette swatch item.
 */
data class PaletteColor(
    val name: String,
    val color: Color
)
