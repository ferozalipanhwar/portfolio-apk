package com.example.portfolio.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apartment
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolio.data.PortfolioData
import com.example.portfolio.model.ExperienceItem
import com.example.portfolio.ui.theme.Cyan400
import com.example.portfolio.ui.theme.Cyan500
import com.example.portfolio.ui.theme.Slate400
import com.example.portfolio.ui.theme.Slate700
import com.example.portfolio.ui.theme.Slate800
import com.example.portfolio.ui.theme.Slate900

@Composable
fun ExperienceSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {
        // Tagline
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(width = 24.dp, height = 2.dp)
                    .background(Cyan400)
            )
            Text(
                text = "CAREER PATH",
                style = MaterialTheme.typography.labelSmall.copy(
                    color = Cyan400,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.5.sp
                )
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Professional Journey",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Black,
                color = Color.White,
                fontSize = 26.sp
            )
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "A timeline of roles where I contributed to high-impact software architectures and user experiences.",
            style = MaterialTheme.typography.bodyMedium.copy(color = Slate400)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Vertical Connected Timeline
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            PortfolioData.experiences.forEachIndexed { index, exp ->
                ExperienceTimelineCard(exp = exp, index = index)
            }
        }
    }
}

@Composable
fun ExperienceTimelineCard(
    exp: ExperienceItem,
    index: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .testTag("experience_item_$index"),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Timeline indicator column
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 4.dp)
        ) {
            // Glowing node dot
            Box(
                modifier = Modifier
                    .size(16.dp)
                    .background(Cyan500, CircleShape)
                    .border(2.dp, Color.White, CircleShape)
            )
            // Vertical connecting line
            Box(
                modifier = Modifier
                    .width(2.dp)
                    .height(140.dp)
                    .background(Cyan500.copy(alpha = 0.35f))
            )
        }

        // Content Card
        Card(
            colors = CardDefaults.cardColors(containerColor = Slate900.copy(alpha = 0.85f)),
            shape = RoundedCornerShape(14.dp),
            border = androidx.compose.foundation.BorderStroke(1.dp, Slate800),
            modifier = Modifier.weight(1f)
        ) {
            Column(modifier = Modifier.padding(14.dp)) {
                // Date tag
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.CalendarToday,
                        contentDescription = null,
                        tint = Cyan400,
                        modifier = Modifier.size(12.dp)
                    )
                    Text(
                        text = exp.date,
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = Cyan400,
                            fontWeight = FontWeight.Bold,
                            fontSize = 11.sp
                        )
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = exp.title,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 16.sp
                    )
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.padding(top = 2.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Apartment,
                        contentDescription = null,
                        tint = Slate400,
                        modifier = Modifier.size(13.dp)
                    )
                    Text(
                        text = exp.company,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Slate400,
                            fontWeight = FontWeight.Medium,
                            fontSize = 13.sp
                        )
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = exp.description,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Slate400,
                        lineHeight = 18.sp,
                        fontSize = 12.sp
                    )
                )

                if (exp.highlights.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        exp.highlights.forEach { highlight ->
                            Row(
                                verticalAlignment = Alignment.Top,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = null,
                                    tint = Cyan400,
                                    modifier = Modifier
                                        .size(12.dp)
                                        .padding(top = 2.dp)
                                )
                                Text(
                                    text = highlight,
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        color = Slate400,
                                        fontSize = 11.sp
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
