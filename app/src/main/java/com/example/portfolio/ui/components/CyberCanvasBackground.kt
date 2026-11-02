package com.example.portfolio.ui.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.example.portfolio.ui.theme.Cyan500
import com.example.portfolio.ui.theme.Purple500
import com.example.portfolio.ui.theme.Slate950
import kotlin.random.Random

data class Particle(
    val xRatio: Float,
    val yRatio: Float,
    val radius: Float,
    val alpha: Float,
    val speed: Float
)

@Composable
fun CyberCanvasBackground(
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition(label = "cyber_bg")
    val phase by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 20000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "phase"
    )

    val particles = remember {
        val rand = Random(42)
        List(40) {
            Particle(
                xRatio = rand.nextFloat(),
                yRatio = rand.nextFloat(),
                radius = rand.nextFloat() * 2.5f + 1f,
                alpha = rand.nextFloat() * 0.4f + 0.15f,
                speed = rand.nextFloat() * 0.5f + 0.5f
            )
        }
    }

    Canvas(modifier = modifier.fillMaxSize()) {
        val width = size.width
        val height = size.height

        // Dark background base
        drawRect(color = Slate950)

        // Radial ambient glow top-left (Cyan)
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(Cyan500.copy(alpha = 0.12f), Color.Transparent),
                center = Offset(width * 0.1f, height * 0.15f),
                radius = width * 0.8f
            ),
            center = Offset(width * 0.1f, height * 0.15f),
            radius = width * 0.8f
        )

        // Radial ambient glow bottom-right (Purple)
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(Purple500.copy(alpha = 0.10f), Color.Transparent),
                center = Offset(width * 0.9f, height * 0.7f),
                radius = width * 0.7f
            ),
            center = Offset(width * 0.9f, height * 0.7f),
            radius = width * 0.7f
        )

        // Ambient cyber nodes / particles
        particles.forEach { p ->
            val animatedY = (p.yRatio * height + (phase * p.speed * 2f)) % height
            val x = p.xRatio * width
            drawCircle(
                color = Cyan500.copy(alpha = p.alpha),
                radius = p.radius,
                center = Offset(x, animatedY)
            )
        }
    }
}
