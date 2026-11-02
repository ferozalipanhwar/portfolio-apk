package com.example.portfolio.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.portfolio.data.PortfolioData
import com.example.portfolio.model.BlogItem
import com.example.portfolio.ui.components.AboutSection
import com.example.portfolio.ui.components.BlogSection
import com.example.portfolio.ui.components.ContactSection
import com.example.portfolio.ui.components.CyberCanvasBackground
import com.example.portfolio.ui.components.ExperienceSection
import com.example.portfolio.ui.components.FeaturedProjectsSection
import com.example.portfolio.ui.components.FooterSection
import com.example.portfolio.ui.components.HeroSection
import com.example.portfolio.ui.components.HireMeSection
import com.example.portfolio.ui.components.NavbarHeader
import com.example.portfolio.ui.components.SkillsSection
import com.example.portfolio.ui.theme.Cyan400
import com.example.portfolio.ui.theme.Cyan500
import com.example.portfolio.ui.theme.Slate400
import com.example.portfolio.ui.theme.Slate700
import com.example.portfolio.ui.theme.Slate800
import com.example.portfolio.ui.theme.Slate900
import com.example.portfolio.ui.theme.Slate950
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToGallery: () -> Unit,
    onNavigateToResume: () -> Unit,
    onOpenUrl: (String) -> Unit,
    onSendEmail: (String, String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var selectedBlog by remember { mutableStateOf<BlogItem?>(null) }
    var showNavSheet by remember { mutableStateOf(false) }

    val showScrollToTop by remember {
        derivedStateOf { listState.firstVisibleItemIndex > 1 }
    }

    Scaffold(
        topBar = {
            NavbarHeader(
                onMenuClick = { showNavSheet = true },
                onHireMeClick = {
                    coroutineScope.launch {
                        // Scroll directly to contact section (index 8)
                        listState.animateScrollToItem(8)
                    }
                }
            )
        },
        floatingActionButton = {
            AnimatedVisibility(
                visible = showScrollToTop,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                FloatingActionButton(
                    onClick = {
                        coroutineScope.launch {
                            listState.animateScrollToItem(0)
                        }
                    },
                    containerColor = Cyan500,
                    contentColor = Slate950,
                    shape = CircleShape,
                    modifier = Modifier.testTag("scroll_to_top_fab")
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = "Scroll to top"
                    )
                }
            }
        },
        containerColor = Slate950
    ) { innerPadding ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Animated Cyber Ambient Canvas
            CyberCanvasBackground()

            LazyColumn(
                state = listState,
                modifier = Modifier.fillMaxSize()
            ) {
                // Item 0: Hero Section
                item {
                    HeroSection(
                        onViewWorkClick = {
                            coroutineScope.launch {
                                listState.animateScrollToItem(4) // Featured Projects
                            }
                        },
                        onDownloadCvClick = onNavigateToResume
                    )
                }

                // Item 1: About Section
                item {
                    AboutSection()
                }

                // Item 2: Skills Section
                item {
                    SkillsSection()
                }

                // Item 3: Experience Section
                item {
                    ExperienceSection()
                }

                // Item 4: Featured Projects Section
                item {
                    FeaturedProjectsSection(onOpenUrl = onOpenUrl)
                }

                // Item 5: Gallery Teaser Card
                item {
                    GalleryTeaserCard(
                        onOpenGallery = onNavigateToGallery
                    )
                }

                // Item 6: Hire Me CTA Section
                item {
                    HireMeSection(
                        onHireMeClick = {
                            coroutineScope.launch {
                                listState.animateScrollToItem(8) // Contact Section
                            }
                        },
                        onWhatsAppClick = {
                            onOpenUrl(PortfolioData.WHATSAPP_URL)
                        }
                    )
                }

                // Item 7: Blog Section
                item {
                    BlogSection(
                        onSelectBlog = { blog -> selectedBlog = blog }
                    )
                }

                // Item 8: Contact Section
                item {
                    ContactSection(
                        onSendEmailIntent = onSendEmail
                    )
                }

                // Item 9: Footer Section
                item {
                    FooterSection(
                        onNavigateToSection = { section ->
                            coroutineScope.launch {
                                when (section) {
                                    "about" -> listState.animateScrollToItem(1)
                                    "skills" -> listState.animateScrollToItem(2)
                                    "experience" -> listState.animateScrollToItem(3)
                                    "projects" -> listState.animateScrollToItem(4)
                                    "gallery" -> onNavigateToGallery()
                                    "blogs" -> listState.animateScrollToItem(7)
                                    "contact" -> listState.animateScrollToItem(8)
                                    else -> listState.animateScrollToItem(0)
                                }
                            }
                        },
                        onOpenUrl = onOpenUrl
                    )
                }
            }
        }
    }

    // Navigation Bottom Sheet
    if (showNavSheet) {
        ModalBottomSheet(
            onDismissRequest = { showNavSheet = false },
            containerColor = Slate900,
            sheetState = rememberModalBottomSheetState()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Text(
                    text = "Navigation Menu",
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                )

                HorizontalDivider(color = Slate800)

                val menuItems = listOf(
                    "Home" to 0,
                    "About Me" to 1,
                    "Tech Stack / Arsenal" to 2,
                    "Experience / Timeline" to 3,
                    "Featured Projects" to 4,
                    "Creative Gallery" to -1, // Route
                    "Resume / CV" to -2, // Route
                    "Latest Blogs" to 7,
                    "Contact Me" to 8
                )

                menuItems.forEach { (label, index) ->
                    Text(
                        text = label,
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = Cyan400,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                showNavSheet = false
                                when (index) {
                                    -1 -> onNavigateToGallery()
                                    -2 -> onNavigateToResume()
                                    else -> {
                                        coroutineScope.launch {
                                            listState.animateScrollToItem(index)
                                        }
                                    }
                                }
                            }
                            .padding(vertical = 8.dp)
                            .testTag("nav_menu_item_${label.lowercase().replace(" ", "_")}")
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }

    // Blog Article Full Reader Dialog
    selectedBlog?.let { blog ->
        Dialog(
            onDismissRequest = { selectedBlog = null },
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Slate950)
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(bottom = 24.dp)
                ) {
                    // Header with close button
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = blog.date,
                            style = MaterialTheme.typography.labelSmall.copy(
                                color = Cyan400,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        IconButton(
                            onClick = { selectedBlog = null },
                            modifier = Modifier
                                .background(Slate900, CircleShape)
                                .testTag("close_blog_reader")
                        ) {
                            Icon(Icons.Default.Close, contentDescription = "Close", tint = Color.White)
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = blog.title,
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontWeight = FontWeight.Black,
                            color = Color.White,
                            fontSize = 22.sp
                        )
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "By ${PortfolioData.AUTHOR_NAME} • ${blog.readTime}",
                        style = MaterialTheme.typography.bodyMedium.copy(color = Slate400, fontSize = 12.sp)
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(blog.imageUrl)
                            .crossfade(true)
                            .build(),
                        contentDescription = blog.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .clip(RoundedCornerShape(14.dp))
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    Text(
                        text = blog.content,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = Slate400,
                            lineHeight = 24.sp,
                            fontSize = 14.sp
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun GalleryTeaserCard(
    onOpenGallery: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Slate900),
        shape = RoundedCornerShape(20.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, Slate800),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 16.dp)
            .clickable(onClick = onOpenGallery)
            .testTag("gallery_teaser_card")
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "CREATIVE GALLERY",
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = Cyan400,
                            fontWeight = FontWeight.Bold,
                            fontSize = 11.sp
                        )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Workspaces & Sprints",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )
                }

                Box(
                    modifier = Modifier
                        .background(Cyan500, RoundedCornerShape(10.dp))
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = "View (6)",
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = Slate950,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Explore behind-the-scenes photographs of development environments, setups, and coding sessions.",
                style = MaterialTheme.typography.bodyMedium.copy(color = Slate400, fontSize = 12.sp)
            )
        }
    }
}
