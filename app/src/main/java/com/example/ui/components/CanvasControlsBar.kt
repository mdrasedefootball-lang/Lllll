package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Redo
import androidx.compose.material.icons.automirrored.filled.Undo
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DeleteSweep
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.RestartAlt
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp

@Composable
fun CanvasControlsBar(
    canUndo: Boolean,
    canRedo: Boolean,
    onUndo: () -> Unit,
    onRedo: () -> Unit,
    onClear: () -> Unit,
    onSave: () -> Unit,
    onZoomIn: () -> Unit,
    onZoomOut: () -> Unit,
    onResetView: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 4.dp)
            .shadow(4.dp, RoundedCornerShape(20.dp)),
        shape = RoundedCornerShape(20.dp),
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.92f),
        tonalElevation = 2.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Group 1: Undo & Redo & Clear
            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                KidActionButton(
                    icon = Icons.AutoMirrored.Filled.Undo,
                    contentDescription = "Undo",
                    testTag = "button_undo",
                    enabled = canUndo,
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    iconTint = MaterialTheme.colorScheme.onSecondaryContainer,
                    onClick = onUndo
                )

                KidActionButton(
                    icon = Icons.AutoMirrored.Filled.Redo,
                    contentDescription = "Redo",
                    testTag = "button_redo",
                    enabled = canRedo,
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    iconTint = MaterialTheme.colorScheme.onSecondaryContainer,
                    onClick = onRedo
                )

                KidActionButton(
                    icon = Icons.Default.DeleteSweep,
                    contentDescription = "Clear Canvas",
                    testTag = "button_clear",
                    enabled = true,
                    containerColor = Color(0xFFFFEBEE),
                    iconTint = Color(0xFFD32F2F),
                    onClick = onClear
                )
            }

            // Group 2: Zoom -, Zoom +, Reset View
            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                KidActionButton(
                    icon = Icons.Default.Remove,
                    contentDescription = "Zoom Out",
                    testTag = "button_zoom_out",
                    enabled = true,
                    containerColor = MaterialTheme.colorScheme.surface,
                    iconTint = MaterialTheme.colorScheme.onSurface,
                    onClick = onZoomOut
                )

                KidActionButton(
                    icon = Icons.Default.Add,
                    contentDescription = "Zoom In",
                    testTag = "button_zoom_in",
                    enabled = true,
                    containerColor = MaterialTheme.colorScheme.surface,
                    iconTint = MaterialTheme.colorScheme.onSurface,
                    onClick = onZoomIn
                )

                KidActionButton(
                    icon = Icons.Default.RestartAlt,
                    contentDescription = "Reset View",
                    testTag = "button_reset_view",
                    enabled = true,
                    containerColor = MaterialTheme.colorScheme.surface,
                    iconTint = MaterialTheme.colorScheme.onSurface,
                    onClick = onResetView
                )
            }

            // Group 3: Save Masterpiece Action
            KidActionButton(
                icon = Icons.Default.Download,
                contentDescription = "Save Masterpiece",
                testTag = "button_save",
                enabled = true,
                containerColor = MaterialTheme.colorScheme.primary,
                iconTint = MaterialTheme.colorScheme.onPrimary,
                onClick = onSave
            )
        }
    }
}

@Composable
private fun KidActionButton(
    icon: ImageVector,
    contentDescription: String,
    testTag: String,
    enabled: Boolean,
    containerColor: Color,
    iconTint: Color,
    onClick: () -> Unit
) {
    FilledTonalIconButton(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier
            .size(44.dp)
            .minimumInteractiveComponentSize()
            .testTag(testTag),
        shape = CircleShape,
        colors = IconButtonDefaults.filledTonalIconButtonColors(
            containerColor = containerColor,
            contentColor = iconTint,
            disabledContainerColor = containerColor.copy(alpha = 0.35f),
            disabledContentColor = iconTint.copy(alpha = 0.35f)
        )
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            modifier = Modifier.size(22.dp)
        )
    }
}
