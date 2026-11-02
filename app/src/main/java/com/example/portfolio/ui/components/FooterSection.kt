package com.example.portfolio.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.portfolio.ui.theme.Cyan400
import com.example.portfolio.ui.theme.Slate400
import com.example.portfolio.ui.theme.Slate700
import com.example.portfolio.ui.theme.Slate800
import com.example.portfolio.ui.theme.Slate900
import com.example.portfolio.ui.theme.Slate950

@Composable
fun FooterSection(
    onNavigateToSection: (String) -> Unit,
    onOpenUrl: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Slate950)
            .border(
                width = 1.dp,
                color = Slate800,
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
            )
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {
        // Brand & Bio
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(28.dp)
                    .background(Cyan400, RoundedCornerShape(6.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Code,
                    contentDescription = null,
                    tint = Slate950,
                    modifier = Modifier.size(16.dp)
                )
            }

            Row {
                Text(
                    text = "Panhwar",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
                Text(
                    text = "Code",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = Cyan400
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Building digital experiences with modern technologies. Mobile applications, web platforms, and scalable backends.",
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Slate400,
                fontSize = 12.sp,
                lineHeight = 18.sp
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Quick Navigation Links
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            listOf("About", "Skills", "Projects", "Gallery", "Blogs", "Contact").forEach { link ->
                Text(
                    text = link,
                    style = MaterialTheme.typography.labelSmall.copy(
                        color = Cyan400,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 11.sp
                    ),
                    modifier = Modifier
                        .clickable { onNavigateToSection(link.lowercase()) }
                        .padding(vertical = 4.dp)
                        .testTag("footer_link_${link.lowercase()}")
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Social Icons Row
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { onOpenUrl(PortfolioData.GITHUB_URL) },
                modifier = Modifier
                    .size(36.dp)
                    .background(Slate900, CircleShape)
                    .border(1.dp, Slate700, CircleShape)
                    .testTag("footer_social_github")
            ) {
                Icon(
                    imageVector = Icons.Default.Code,
                    contentDescription = "GitHub",
                    tint = Color.White,
                    modifier = Modifier.size(18.dp)
                )
            }

            IconButton(
                onClick = { onOpenUrl(PortfolioData.LINKEDIN_URL) },
                modifier = Modifier
                    .size(36.dp)
                    .background(Slate900, CircleShape)
                    .border(1.dp, Slate700, CircleShape)
                    .testTag("footer_social_linkedin")
            ) {
                Icon(
                    imageVector = Icons.Default.Link,
                    contentDescription = "LinkedIn",
                    tint = Cyan400,
                    modifier = Modifier.size(18.dp)
                )
            }

            IconButton(
                onClick = { onOpenUrl("mailto:${PortfolioData.EMAIL}") },
                modifier = Modifier
                    .size(36.dp)
                    .background(Slate900, CircleShape)
                    .border(1.dp, Slate700, CircleShape)
                    .testTag("footer_social_email")
            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email",
                    tint = Cyan400,
                    modifier = Modifier.size(18.dp)
                )
            }

            IconButton(
                onClick = { onOpenUrl(PortfolioData.WHATSAPP_URL) },
                modifier = Modifier
                    .size(36.dp)
                    .background(Slate900, CircleShape)
                    .border(1.dp, Slate700, CircleShape)
                    .testTag("footer_social_whatsapp")
            ) {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = "WhatsApp",
                    tint = Color(0xFF4ADE80),
                    modifier = Modifier.size(18.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider(color = Slate800, thickness = 1.dp)
        Spacer(modifier = Modifier.height(14.dp))

        // Copyright line
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "© 2026 FEROZ ALI PANHWAR. All rights reserved.",
                style = MaterialTheme.typography.labelSmall.copy(
                    color = Slate400,
                    fontSize = 11.sp
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "Made with",
                    style = MaterialTheme.typography.labelSmall.copy(color = Slate400, fontSize = 10.sp)
                )
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Heart",
                    tint = Color(0xFFEF4444),
                    modifier = Modifier.size(12.dp)
                )
                Text(
                    text = "in Pakistan • Kotlin & Jetpack Compose",
                    style = MaterialTheme.typography.labelSmall.copy(color = Slate400, fontSize = 10.sp)
                )
            }
        }
    }
}
