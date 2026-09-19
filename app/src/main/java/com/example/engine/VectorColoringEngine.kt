package com.example.engine

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Region
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.graphics.toArgb
import androidx.core.graphics.PathParser
import com.example.data.models.ColorableRegion
import com.example.data.models.ColoringPage

/**
 * Precomputed geometry cache for efficient hit testing and instant rendering.
 */
class ParsedRegion(
    val region: ColorableRegion,
    val androidPath: android.graphics.Path,
    val composePath: androidx.compose.ui.graphics.Path,
    val bounds: RectF,
    val hitRegion: Region,
    val area: Float
)

class VectorColoringEngine(val page: ColoringPage) {

    val parsedRegions: List<ParsedRegion>

    init {
        val list = mutableListOf<ParsedRegion>()
        val clipBounds = Region(0, 0, page.viewBoxWidth.toInt() + 10, page.viewBoxHeight.toInt() + 10)

        for (item in page.regions) {
            try {
                val androidPath = PathParser.createPathFromPathData(item.pathData)
                val bounds = RectF()
                androidPath.computeBounds(bounds, true)

                val hitRegion = Region()
                hitRegion.setPath(androidPath, clipBounds)

                val area = bounds.width() * bounds.height()
                list.add(
                    ParsedRegion(
                        region = item,
                        androidPath = androidPath,
                        composePath = androidPath.asComposePath(),
                        bounds = bounds,
                        hitRegion = hitRegion,
                        area = if (area > 0f) area else 1f
                    )
                )
            } catch (e: Exception) {
                // Ignore any malformed path gracefully
            }
        }
        parsedRegions = list
    }

    /**
     * Smart tap-to-fill point detection.
     * Finds the exact enclosed region containing (x, y).
     * If multiple regions overlap, prioritizes the one with the smallest area
     * (e.g. eyes, pupils, gems, stars, buttons inside bigger shapes).
     */
    fun findRegionAt(x: Float, y: Float): ColorableRegion? {
        val ix = x.toInt()
        val iy = y.toInt()

        val candidates = mutableListOf<ParsedRegion>()

        for (parsed in parsedRegions) {
            if (parsed.hitRegion.contains(ix, iy)) {
                candidates.add(parsed)
            }
        }

        if (candidates.isNotEmpty()) {
            // Sort by smallest area first so small enclosed details get chosen
            return candidates.minByOrNull { it.area }?.region
        }

        // Proximity fallback for tiny regions or touches right on thick outlines (within 8 units)
        var closest: ParsedRegion? = null
        var minDistanceSq = 64f // 8*8

        for (parsed in parsedRegions) {
            if (parsed.bounds.contains(x, y)) {
                return parsed.region
            }
            val centerX = parsed.bounds.centerX()
            val centerY = parsed.bounds.centerY()
            val distSq = (x - centerX) * (x - centerX) + (y - centerY) * (y - centerY)
            if (distSq < minDistanceSq) {
                minDistanceSq = distSq
                closest = parsed
            }
        }

        return closest?.region
    }

    /**
     * Exports a pristine, high-resolution PNG bitmap of the colored artwork.
     * Includes pure white background, applied colors, and crisp black outlines.
     */
    fun exportToBitmap(
        appliedFills: Map<String, Color>,
        targetWidth: Int = 1200,
        targetHeight: Int = 1200
    ): Bitmap {
        val bitmap = Bitmap.createBitmap(targetWidth, targetHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)

        // Draw pure white background
        canvas.drawColor(android.graphics.Color.WHITE)

        val scaleX = targetWidth / page.viewBoxWidth
        val scaleY = targetHeight / page.viewBoxHeight
        canvas.scale(scaleX, scaleY)

        val fillPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.FILL
        }

        val strokePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.STROKE
            color = android.graphics.Color.BLACK
            strokeCap = Paint.Cap.ROUND
            strokeJoin = Paint.Join.ROUND
        }

        // 1. Draw all fills
        for (parsed in parsedRegions) {
            val fill = appliedFills[parsed.region.id] ?: parsed.region.defaultFill
            fillPaint.color = fill.toArgb()
            canvas.drawPath(parsed.androidPath, fillPaint)
        }

        // 2. Draw all black outlines on top
        for (parsed in parsedRegions) {
            strokePaint.strokeWidth = parsed.region.strokeWidth
            canvas.drawPath(parsed.androidPath, strokePaint)
        }

        return bitmap
    }
}
