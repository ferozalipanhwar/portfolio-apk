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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.LaptopMac
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.RocketLaunch
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolio.data.PortfolioData
import com.example.portfolio.ui.theme.Cyan400
import com.example.portfolio.ui.theme.Cyan500
import com.example.portfolio.ui.theme.Emerald400
import com.example.portfolio.ui.theme.Purple500
import com.example.portfolio.ui.theme.Slate300
import com.example.portfolio.ui.theme.Slate400
import com.example.portfolio.ui.theme.Slate700
import com.example.portfolio.ui.theme.Slate800
import com.example.portfolio.ui.theme.Slate900

data class HighlightService(
    val title: String,
    val subtitle: String,
    val icon: ImageVector,
    val accentColor: Color
)

@Composable
fun AboutSection(
    modifier: Modifier = Modifier
) {
    val services = listOf(
        HighlightService("Web Dev", "Full Stack / MERN", Icons.Default.LaptopMac, Cyan400),
        HighlightService("Mobile", "React Native & Android", Icons.Default.PhoneAndroid, Purple500),
        HighlightService("Logic", "Data Architecture & Problem Solving", Icons.Default.Build, Emerald400)
    )

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
                text = "WHO I AM",
                style = MaterialTheme.typography.labelSmall.copy(
                    color = Cyan400,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.5.sp
                )
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Experience Badge Pill
        Box(
            modifier = Modifier
                .background(Slate900.copy(alpha = 0.9f), RoundedCornerShape(12.dp))
                .border(1.dp, Cyan400.copy(alpha = 0.3f), RoundedCornerShape(12.dp))
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .background(Cyan500.copy(alpha = 0.2f), RoundedCornerShape(8.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.RocketLaunch,
                        contentDescription = null,
                        tint = Cyan400,
                        modifier = Modifier.size(18.dp)
                    )
                }
                Column {
                    Text(
                        text = "EXPERIENCE",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontSize = 9.sp,
                            color = Slate400,
                            letterSpacing = 1.sp
                        )
                    )
                    Text(
                        text = "Pro Developer & Architect",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 12.sp
                        )
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        // Section Title
        Row {
            Text(
                text = "About ",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Black,
                    color = Color.White,
                    fontSize = 30.sp
                )
            )
            Text(
                text = "Me.",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Black,
                    brush = Brush.horizontalGradient(listOf(Cyan400, Purple500)),
                    fontSize = 30.sp
                )
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Bio Card
        Card(
            colors = CardDefaults.cardColors(containerColor = Slate900.copy(alpha = 0.7f)),
            shape = RoundedCornerShape(16.dp),
            border = androidx.compose.foundation.BorderStroke(1.dp, Slate700)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = PortfolioData.BIO_SUMMARY,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Slate300,
                        lineHeight = 22.sp
                    )
                )

                Spacer(modifier = Modifier.height(14.dp))

                Text(
                    text = "Based in ${PortfolioData.LOCATION}, I build software with modern architecture, rock-solid security, and obsessive attention to smooth micro-interactions.",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Slate400,
                        lineHeight = 20.sp
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 3 Capability Cards
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            services.forEach { service ->
                Card(
                    colors = CardDefaults.cardColors(containerColor = Slate900.copy(alpha = 0.5f)),
                    shape = RoundedCornerShape(12.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, service.accentColor.copy(alpha = 0.3f))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(42.dp)
                                .background(service.accentColor.copy(alpha = 0.15f), RoundedCornerShape(10.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = service.icon,
                                contentDescription = service.title,
                                tint = service.accentColor,
                                modifier = Modifier.size(24.dp)
                            )
                        }

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = service.title,
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    fontSize = 15.sp
                                )
                            )
                            Text(
                                text = service.subtitle,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    color = Slate400,
                                    fontSize = 12.sp
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}
