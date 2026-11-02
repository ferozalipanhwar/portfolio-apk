package com.example.portfolio

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.portfolio.data.PortfolioData
import com.example.portfolio.ui.screens.GalleryScreen
import com.example.portfolio.ui.screens.HomeScreen
import com.example.portfolio.ui.screens.ResumeScreen
import com.example.portfolio.ui.theme.PanhwarPortfolioTheme
import com.example.portfolio.ui.theme.Slate950

sealed class Screen {
    object Home : Screen()
    object Gallery : Screen()
    object Resume : Screen()
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            PanhwarPortfolioTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Slate950
                ) {
                    var currentScreen by remember { mutableStateOf<Screen>(Screen.Home) }

                    // Predictive Back Handling
                    BackHandler(enabled = currentScreen != Screen.Home) {
                        currentScreen = Screen.Home
                    }

                    Crossfade(targetState = currentScreen, label = "screen_transition") { screen ->
                        when (screen) {
                            Screen.Home -> {
                                HomeScreen(
                                    onNavigateToGallery = { currentScreen = Screen.Gallery },
                                    onNavigateToResume = { currentScreen = Screen.Resume },
                                    onOpenUrl = { url -> openWebUrl(url) },
                                    onSendEmail = { name, email, msg ->
                                        sendEmailIntent(name, email, msg)
                                    }
                                )
                            }
                            Screen.Gallery -> {
                                GalleryScreen(
                                    onBackClick = { currentScreen = Screen.Home }
                                )
                            }
                            Screen.Resume -> {
                                ResumeScreen(
                                    onBackClick = { currentScreen = Screen.Home },
                                    onShareClick = { shareResumeInfo() },
                                    onContactClick = {
                                        currentScreen = Screen.Home
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    private fun openWebUrl(url: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(this, "Could not open link: $url", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sendEmailIntent(name: String, email: String, message: String) {
        try {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:${PortfolioData.EMAIL}")
                putExtra(Intent.EXTRA_SUBJECT, "Portfolio Contact from $name")
                putExtra(Intent.EXTRA_TEXT, "Name: $name\nEmail: $email\n\nMessage:\n$message")
            }
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(this, "Opening email client...", Toast.LENGTH_SHORT).show()
        }
    }

    private fun shareResumeInfo() {
        try {
            val shareText = """
                Check out the portfolio of ${PortfolioData.AUTHOR_NAME}
                ${PortfolioData.ROLE_TITLE}
                Email: ${PortfolioData.EMAIL}
                GitHub: ${PortfolioData.GITHUB_URL}
                WhatsApp: ${PortfolioData.PHONE}
            """.trimIndent()

            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, shareText)
            }
            startActivity(Intent.createChooser(intent, "Share Profile"))
        } catch (e: Exception) {
            Toast.makeText(this, "Failed to share profile", Toast.LENGTH_SHORT).show()
        }
    }
}
