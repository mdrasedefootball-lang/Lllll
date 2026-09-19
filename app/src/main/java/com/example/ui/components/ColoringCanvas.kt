package com.example.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.data.models.ColoringPage
import com.example.engine.VectorColoringEngine
import com.example.ui.SparkleEvent
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

@Composable
fun ColoringCanvas(
    page: ColoringPage,
    engine: VectorColoringEngine,
    appliedFills: Map<String, Color>,
    zoomScale: Float,
    panOffset: Offset,
    sparkleEvent: SparkleEvent?,
    onRegionTap: (svgX: Float, svgY: Float, canvasX: Float, canvasY: Float) -> Unit,
    onPanZoom: (zoomChange: Float, panChange: Offset) -> Unit,
    onDoubleTapReset: () -> Unit,
    onSparkleComplete: () -> Unit,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
            .testTag("coloring_canvas_container"),
        contentAlignment = Alignment.Center
    ) {
        val containerWidth = constraints.maxWidth.toFloat()
        val containerHeight = constraints.maxHeight.toFloat()

        val baseScale = min(
            containerWidth / page.viewBoxWidth,
            containerHeight / page.viewBoxHeight
        ) * 0.94f

        val totalScale = baseScale * zoomScale

        Box(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTransformGestures { _, pan, zoom, _ ->
                        onPanZoom(zoom, pan)
                    }
                }
                .pointerInput(page.id, zoomScale, panOffset) {
                    detectTapGestures(
                        onDoubleTap = { onDoubleTapReset() },
                        onTap = { tapOffset ->
                            val centerX = containerWidth / 2f + panOffset.x
                            val centerY = containerHeight / 2f + panOffset.y

                            val dx = tapOffset.x - centerX
                            val dy = tapOffset.y - centerY

                            val svgX = (dx / totalScale) + (page.viewBoxWidth / 2f)
                            val svgY = (dy / totalScale) + (page.viewBoxHeight / 2f)

                            if (svgX in -20f..(page.viewBoxWidth + 20f) &&
                                svgY in -20f..(page.viewBoxHeight + 20f)
                            ) {
                                onRegionTap(svgX, svgY, tapOffset.x, tapOffset.y)
                            }
                        }
                    )
                }
        ) {
            Canvas(
                modifier = Modifier
                    .fillMaxSize()
                    .testTag("coloring_vector_canvas")
            ) {
                val centerX = containerWidth / 2f + panOffset.x
                val centerY = containerHeight / 2f + panOffset.y

                translate(left = centerX, top = centerY) {
                    scale(scale = totalScale, pivot = Offset.Zero) {
                        translate(
                            left = -page.viewBoxWidth / 2f,
                            top = -page.viewBoxHeight / 2f
                        ) {
                            // 1. Draw page paper background with subtle rounded border
                            drawRect(
                                color = Color.White,
                                topLeft = Offset(0f, 0f),
                                size = Size(page.viewBoxWidth, page.viewBoxHeight)
                            )

                            // 2. Draw all region fills
                            for (parsed in engine.parsedRegions) {
                                val fill = appliedFills[parsed.region.id] ?: parsed.region.defaultFill
                                drawPath(
                                    path = parsed.composePath,
                                    color = fill,
                                    style = Fill
                                )
                            }

                            // 3. Draw all black outlines on top with smooth rounded caps
                            for (parsed in engine.parsedRegions) {
                                drawPath(
                                    path = parsed.composePath,
                                    color = Color.Black,
                                    style = Stroke(
                                        width = parsed.region.strokeWidth,
                                        cap = StrokeCap.Round,
                                        join = StrokeJoin.Round
                                    )
                                )
                            }

                            // Page outer boundary frame
                            drawRect(
                                color = Color.Black.copy(alpha = 0.85f),
                                topLeft = Offset(0f, 0f),
                                size = Size(page.viewBoxWidth, page.viewBoxHeight),
                                style = Stroke(width = 3.5f)
                            )
                        }
                    }
                }
            }

            // Sparkle Particle Animation
            if (sparkleEvent != null) {
                SparkleBurstOverlay(
                    event = sparkleEvent,
                    onFinished = onSparkleComplete
                )
            }
        }
    }
}

@Composable
private fun SparkleBurstOverlay(
    event: SparkleEvent,
    onFinished: () -> Unit
) {
    val progress = remember(event.id) { Animatable(0f) }

    LaunchedEffect(event.id) {
        progress.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 450, easing = LinearOutSlowInEasing)
        )
        onFinished()
    }

    Canvas(modifier = Modifier.fillMaxSize()) {
        val currentP = progress.value
        val alpha = (1f - currentP).coerceIn(0f, 1f)
        val maxRadius = 55f
        val particleRadius = 6f * (1f - currentP * 0.4f)

        // 8 radiating sparkle particles
        for (i in 0 until 8) {
            val angle = (i * (360f / 8f)) * (Math.PI / 180f)
            val distance = currentP * maxRadius
            val px = event.x + (cos(angle) * distance).toFloat()
            val py = event.y + (sin(angle) * distance).toFloat()

            drawCircle(
                color = event.color.copy(alpha = alpha),
                radius = particleRadius,
                center = Offset(px, py)
            )

            // Central glow ring
            drawCircle(
                color = Color.White.copy(alpha = alpha * 0.8f),
                radius = currentP * 25f,
                center = Offset(event.x, event.y),
                style = Stroke(width = 3f * (1f - currentP))
            )
        }
    }
}
