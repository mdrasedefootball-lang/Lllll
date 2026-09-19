package com.example.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.ColoringRepository
import com.example.data.models.PaletteColor

@Composable
fun ColorPaletteBar(
    selectedColor: Color,
    onColorSelected: (Color) -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 6.dp)
            .shadow(6.dp, shape = RoundedCornerShape(24.dp)),
        shape = RoundedCornerShape(24.dp),
        color = MaterialTheme.colorScheme.surface.copy(alpha = 0.95f),
        tonalElevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            // Selected Color Indicator Label
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 2.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(16.dp)
                            .clip(CircleShape)
                            .background(selectedColor)
                            .border(1.5.dp, Color.Black.copy(alpha = 0.4f), CircleShape)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    val currentColorName = ColoringRepository.paletteColors
                        .find { it.color == selectedColor }?.name ?: "Selected Color"
                    Text(
                        text = currentColorName,
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        ),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }

                Text(
                    text = "24 Vibrant Colors",
                    style = MaterialTheme.typography.labelSmall.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f)
                    )
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            // Scrollable Color Swatches Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(scrollState)
                    .padding(horizontal = 12.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ColoringRepository.paletteColors.forEach { paletteItem ->
                    ColorSwatchButton(
                        paletteColor = paletteItem,
                        isSelected = paletteItem.color == selectedColor,
                        onSelect = { onColorSelected(paletteItem.color) }
                    )
                }
            }
        }
    }
}

@Composable
private fun ColorSwatchButton(
    paletteColor: PaletteColor,
    isSelected: Boolean,
    onSelect: () -> Unit
) {
    val scale by animateFloatAsState(
        targetValue = if (isSelected) 1.18f else 1.0f,
        animationSpec = spring(dampingRatio = 0.6f, stiffness = 400f),
        label = "colorScale"
    )

    val isDark = paletteColor.color.luminance() < 0.45f
    val checkColor = if (isDark) Color.White else Color.Black

    Box(
        modifier = Modifier
            .size(52.dp)
            .scale(scale)
            .testTag("color_swatch_${paletteColor.name.lowercase().replace(' ', '_')}")
            .clip(CircleShape)
            .clickable(onClick = onSelect),
        contentAlignment = Alignment.Center
    ) {
        // Outer selection ring
        if (isSelected) {
            Box(
                modifier = Modifier
                    .size(52.dp)
                    .clip(CircleShape)
                    .background(Color.Transparent)
                    .border(3.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
            )
        }

        // Color circle
        Box(
            modifier = Modifier
                .size(if (isSelected) 40.dp else 44.dp)
                .shadow(elevation = if (isSelected) 4.dp else 2.dp, shape = CircleShape)
                .clip(CircleShape)
                .background(paletteColor.color)
                .border(
                    width = if (paletteColor.color == Color.White) 2.dp else 1.dp,
                    color = if (paletteColor.color == Color.White) Color.LightGray else Color.Black.copy(alpha = 0.15f),
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            if (isSelected) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Selected",
                    tint = checkColor,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}
