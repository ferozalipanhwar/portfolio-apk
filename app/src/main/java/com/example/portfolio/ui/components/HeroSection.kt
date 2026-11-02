package com.example.portfolio.ui.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Description
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.portfolio.R
import com.example.portfolio.data.PortfolioData
import com.example.portfolio.ui.theme.Blue500
import com.example.portfolio.ui.theme.Cyan400
import com.example.portfolio.ui.theme.Cyan500
import com.example.portfolio.ui.theme.Purple500
import com.example.portfolio.ui.theme.Slate400
import com.example.portfolio.ui.theme.Slate700
import com.example.portfolio.ui.theme.Slate800
import com.example.portfolio.ui.theme.Slate900

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HeroSection(
    onViewWorkClick: () -> Unit,
    onDownloadCvClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition(label = "hero_rings")
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(12000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "ring_rotate"
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Avatar with Cyber Halo Ring
        Box(
            modifier = Modifier.size(190.dp),
            contentAlignment = Alignment.Center
        ) {
            // Rotating dashed gradient circle
            Box(
                modifier = Modifier
                    .size(185.dp)
                    .rotate(rotation)
                    .border(
                        width = 2.dp,
                        brush = Brush.sweepGradient(
                            listOf(Cyan400, Purple500, Blue500, Cyan400)
                        ),
                        shape = CircleShape
                    )
            )

            // Inner glowing container
            Box(
                modifier = Modifier
                    .size(160.dp)
                    .clip(CircleShape)
                    .background(
                        brush = Brush.verticalGradient(listOf(Cyan500, Slate900)),
                        shape = CircleShape
                    )
                    .border(3.dp, Slate900, CircleShape)
                    .padding(3.dp)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(R.drawable.feroz_avatar)
                        .crossfade(true)
                        .build(),
                    contentDescription = "Feroz Ali Panhwar Profile Photo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(154.dp)
                        .clip(CircleShape)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Pre-header badge
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Slate900,
            border = androidx.compose.foundation.BorderStroke(1.dp, Cyan400.copy(alpha = 0.4f))
        ) {
            Text(
                text = "⚡ HELLO WORLD",
                style = MaterialTheme.typography.labelSmall.copy(
                    color = Cyan400,
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.sp
                ),
                modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        // Main Title
        Text(
            text = "I'm",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
        )

        Text(
            text = "FEROZ ALI PANHWAR",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontWeight = FontWeight.Black,
                fontSize = 28.sp,
                brush = Brush.horizontalGradient(
                    listOf(Cyan400, Blue500, Purple500)
                )
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = PortfolioData.ROLE_TITLE,
            style = MaterialTheme.typography.titleMedium.copy(
                color = Cyan400,
                fontWeight = FontWeight.SemiBold
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "I build pixel-perfect, interactive, and high-performance digital experiences. Welcome to my Android & Full Stack digital playground!",
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Slate400,
                lineHeight = 22.sp
            ),
            modifier = Modifier.padding(horizontal = 8.dp),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Tech pills
        FlowRow(
            horizontalArrangement = Arrangement.Center,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            val quickTech = listOf("React", "React Native", "Node.js", "TypeScript", "Kotlin", "Firebase")
            quickTech.forEach { tech ->
                Box(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .background(Slate800.copy(alpha = 0.8f), RoundedCornerShape(8.dp))
                        .border(1.dp, Slate700, RoundedCornerShape(8.dp))
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                ) {
                    Text(
                        text = tech,
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = Color.White,
                            fontSize = 11.sp
                        )
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Action Buttons Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(
                onClick = onViewWorkClick,
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Cyan500,
                    contentColor = Color.Black
                ),
                modifier = Modifier
                    .weight(1f)
                    .testTag("hero_view_work_button")
            ) {
                Text(
                    text = "View My Work",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                )
                Spacer(modifier = Modifier.size(6.dp))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
            }

            OutlinedButton(
                onClick = onDownloadCvClick,
                shape = RoundedCornerShape(12.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, Cyan400.copy(alpha = 0.6f)),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Cyan400
                ),
                modifier = Modifier
                    .weight(1f)
                    .testTag("hero_download_cv_button")
            ) {
                Icon(
                    imageVector = Icons.Default.Description,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.size(6.dp))
                Text(
                    text = "View Resume",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                )
            }
        }
    }
}
