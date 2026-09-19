package com.example.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.CrueltyFree
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.RocketLaunch
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.PathParser
import com.example.data.ColoringRepository
import com.example.data.models.ColoringBook
import com.example.data.models.ColoringPage

@Composable
fun BookAndPageSelector(
    currentBook: ColoringBook,
    currentPage: ColoringPage,
    pageFills: Map<String, Color>,
    getCompletionPercent: (String) -> Int,
    onSelectBook: (ColoringBook) -> Unit,
    onSelectPage: (ColoringPage) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(vertical = 4.dp)
    ) {
        // 1. Book Selector Tabs
        ScrollableTabRow(
            selectedTabIndex = ColoringRepository.books.indexOfFirst { it.id == currentBook.id }.coerceAtLeast(0),
            edgePadding = 12.dp,
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.primary,
            indicator = { tabPositions ->
                val index = ColoringRepository.books.indexOfFirst { it.id == currentBook.id }.coerceAtLeast(0)
                if (index < tabPositions.size) {
                    TabRowDefaults.SecondaryIndicator(
                        modifier = Modifier.tabIndicatorOffset(tabPositions[index]),
                        color = currentBook.accentColor,
                        height = 3.dp
                    )
                }
            },
            divider = {}
        ) {
            ColoringRepository.books.forEach { book ->
                val isSelected = book.id == currentBook.id
                Tab(
                    selected = isSelected,
                    onClick = { onSelectBook(book) },
                    modifier = Modifier.testTag("book_tab_${book.id}")
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        val icon: ImageVector = when (book.iconName) {
                            "Pets" -> Icons.Default.Pets
                            "RocketLaunch" -> Icons.Default.RocketLaunch
                            "CrueltyFree" -> Icons.Default.CrueltyFree
                            else -> Icons.Default.AutoAwesome
                        }

                        Box(
                            modifier = Modifier
                                .size(28.dp)
                                .clip(CircleShape)
                                .background(if (isSelected) book.accentColor else book.accentColor.copy(alpha = 0.2f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = icon,
                                contentDescription = null,
                                tint = if (isSelected) Color.White else book.accentColor,
                                modifier = Modifier.size(16.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(6.dp))

                        Text(
                            text = book.shortTitle,
                            style = MaterialTheme.typography.labelLarge.copy(
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                color = if (isSelected) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(6.dp))

        // 2. Page Selector Miniature Cards
        val pageScrollState = rememberScrollState()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(pageScrollState)
                .padding(horizontal = 12.dp, vertical = 2.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            currentBook.pages.forEachIndexed { index, page ->
                val isPageSelected = page.id == currentPage.id
                val completion = getCompletionPercent(page.id)

                PageThumbnailCard(
                    page = page,
                    pageNumber = index + 1,
                    isSelected = isPageSelected,
                    accentColor = currentBook.accentColor,
                    completionPercent = completion,
                    activeFills = if (isPageSelected) pageFills else emptyMap(),
                    onClick = { onSelectPage(page) }
                )
            }
        }
    }
}

@Composable
private fun PageThumbnailCard(
    page: ColoringPage,
    pageNumber: Int,
    isSelected: Boolean,
    accentColor: Color,
    completionPercent: Int,
    activeFills: Map<String, Color>,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(135.dp)
            .testTag("page_card_${page.id}")
            .shadow(
                elevation = if (isSelected) 6.dp else 2.dp,
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = if (isSelected) 3.dp else 1.dp,
                color = if (isSelected) accentColor else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
                shape = RoundedCornerShape(16.dp)
            )
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) accentColor.copy(alpha = 0.08f) else MaterialTheme.colorScheme.surface
        )
    ) {
        Column(modifier = Modifier.padding(6.dp)) {
            // Mini Vector Drawing Preview
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.White)
                    .border(1.dp, Color.LightGray.copy(alpha = 0.5f), RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center
            ) {
                MiniPageVectorPreview(
                    page = page,
                    fills = activeFills
                )

                // Page Number Tag
                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(4.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(Color.Black.copy(alpha = 0.65f))
                        .padding(horizontal = 5.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = "Page $pageNumber",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )
                }

                // Completion badge
                if (completionPercent > 0) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(4.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(Color(0xFF34C759))
                            .padding(horizontal = 4.dp, vertical = 1.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                tint = Color.Yellow,
                                modifier = Modifier.size(10.dp)
                            )
                            Spacer(modifier = Modifier.width(2.dp))
                            Text(
                                text = "$completionPercent%",
                                style = MaterialTheme.typography.labelSmall.copy(
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            // Page Title
            Text(
                text = page.title,
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.SemiBold,
                    fontSize = 11.sp
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
private fun MiniPageVectorPreview(
    page: ColoringPage,
    fills: Map<String, Color>
) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val miniScale = (size.width / page.viewBoxWidth).coerceAtMost(size.height / page.viewBoxHeight) * 0.9f
        val offsetX = (size.width - page.viewBoxWidth * miniScale) / 2f
        val offsetY = (size.height - page.viewBoxHeight * miniScale) / 2f

        scale(scale = miniScale, pivot = Offset.Zero) {
            // Draw up to 15 key regions for fast thumbnail rendering
            val regionsToDraw = page.regions.take(18)
            for (region in regionsToDraw) {
                try {
                    val androidPath = PathParser.createPathFromPathData(region.pathData)
                    val composePath = androidPath.asComposePath()
                    val fill = fills[region.id] ?: region.defaultFill

                    drawPath(
                        path = composePath,
                        color = fill
                    )
                    drawPath(
                        path = composePath,
                        color = Color.Black,
                        style = Stroke(
                            width = 2.5f,
                            cap = StrokeCap.Round,
                            join = StrokeJoin.Round
                        )
                    )
                } catch (e: Exception) {
                    // Skip gracefully
                }
            }
        }
    }
}
