package com.example.portfolio.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolio.data.PortfolioData
import com.example.portfolio.ui.components.CyberCanvasBackground
import com.example.portfolio.ui.theme.Cyan400
import com.example.portfolio.ui.theme.Cyan500
import com.example.portfolio.ui.theme.Emerald400
import com.example.portfolio.ui.theme.Slate400
import com.example.portfolio.ui.theme.Slate700
import com.example.portfolio.ui.theme.Slate800
import com.example.portfolio.ui.theme.Slate900
import com.example.portfolio.ui.theme.Slate950

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResumeScreen(
    onBackClick: () -> Unit,
    onShareClick: () -> Unit,
    onContactClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Curriculum Vitae",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBackClick,
                        modifier = Modifier.testTag("resume_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Cyan400
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = onShareClick,
                        modifier = Modifier.testTag("resume_share_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = "Share CV",
                            tint = Cyan400
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Slate950.copy(alpha = 0.95f)
                )
            )
        },
        containerColor = Slate950
    ) { innerPadding ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            CyberCanvasBackground()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(20.dp)
            ) {
                // Header profile card
                Card(
                    colors = CardDefaults.cardColors(containerColor = Slate900),
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, Cyan400.copy(alpha = 0.3f)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(18.dp)) {
                        Text(
                            text = PortfolioData.AUTHOR_NAME,
                            style = MaterialTheme.typography.headlineMedium.copy(
                                fontWeight = FontWeight.Black,
                                color = Color.White
                            )
                        )
                        Text(
                            text = PortfolioData.ROLE_TITLE,
                            style = MaterialTheme.typography.titleMedium.copy(
                                color = Cyan400,
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Email: ${PortfolioData.EMAIL}",
                            style = MaterialTheme.typography.bodyMedium.copy(color = Slate400, fontSize = 12.sp)
                        )
                        Text(
                            text = "Phone: ${PortfolioData.PHONE}",
                            style = MaterialTheme.typography.bodyMedium.copy(color = Slate400, fontSize = 12.sp)
                        )
                        Text(
                            text = "Location: ${PortfolioData.LOCATION}",
                            style = MaterialTheme.typography.bodyMedium.copy(color = Slate400, fontSize = 12.sp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Summary statement
                ResumeSectionHeader(title = "PROFESSIONAL SUMMARY")
                Spacer(modifier = Modifier.height(8.dp))
                Card(
                    colors = CardDefaults.cardColors(containerColor = Slate900.copy(alpha = 0.7f)),
                    shape = RoundedCornerShape(12.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, Slate800)
                ) {
                    Text(
                        text = PortfolioData.BIO_SUMMARY,
                        style = MaterialTheme.typography.bodyMedium.copy(color = Slate400, lineHeight = 20.sp),
                        modifier = Modifier.padding(14.dp)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Technical Competencies
                ResumeSectionHeader(title = "TECHNICAL COMPETENCIES")
                Spacer(modifier = Modifier.height(8.dp))
                Card(
                    colors = CardDefaults.cardColors(containerColor = Slate900.copy(alpha = 0.7f)),
                    shape = RoundedCornerShape(12.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, Slate800)
                ) {
                    Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        ResumeSkillRow("Languages", "JavaScript (ES6+), TypeScript, Kotlin, Python, Java, PHP, SQL")
                        ResumeSkillRow("Frontend", "React.js, Next.js, Redux Toolkit, Tailwind CSS, HTML5, CSS3")
                        ResumeSkillRow("Mobile", "React Native (CLI & Expo), Jetpack Compose, Native Modules")
                        ResumeSkillRow("Backend & DB", "Node.js, Express.js, RESTful APIs, MongoDB, Firebase, PostgreSQL")
                        ResumeSkillRow("Tools & DevOps", "Git, GitHub, Vite, Postman, Figma, Docker, Cloud Run")
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Work Experience
                ResumeSectionHeader(title = "WORK EXPERIENCE")
                Spacer(modifier = Modifier.height(8.dp))
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    PortfolioData.experiences.forEach { exp ->
                        Card(
                            colors = CardDefaults.cardColors(containerColor = Slate900.copy(alpha = 0.8f)),
                            shape = RoundedCornerShape(12.dp),
                            border = androidx.compose.foundation.BorderStroke(1.dp, Slate800)
                        ) {
                            Column(modifier = Modifier.padding(14.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = exp.title,
                                        style = MaterialTheme.typography.titleMedium.copy(
                                            fontWeight = FontWeight.Bold,
                                            color = Color.White,
                                            fontSize = 15.sp
                                        )
                                    )
                                    Text(
                                        text = exp.date,
                                        style = MaterialTheme.typography.labelSmall.copy(
                                            color = Cyan400,
                                            fontSize = 10.sp
                                        )
                                    )
                                }
                                Text(
                                    text = exp.company,
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        color = Slate400,
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 12.sp
                                    )
                                )
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = exp.description,
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        color = Slate400,
                                        fontSize = 12.sp,
                                        lineHeight = 18.sp
                                    )
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Education
                ResumeSectionHeader(title = "EDUCATION & CREDENTIALS")
                Spacer(modifier = Modifier.height(8.dp))
                Card(
                    colors = CardDefaults.cardColors(containerColor = Slate900.copy(alpha = 0.7f)),
                    shape = RoundedCornerShape(12.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, Slate800)
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.School,
                                contentDescription = null,
                                tint = Cyan400,
                                modifier = Modifier.size(18.dp)
                            )
                            Text(
                                text = "Bachelor of Science in Computer Science (BSCS)",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    fontSize = 14.sp
                                )
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Specialization in Software Engineering, Full-Stack Systems & Mobile Platforms",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                color = Slate400,
                                fontSize = 12.sp
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(28.dp))

                // Actions
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Button(
                        onClick = onContactClick,
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Cyan500,
                            contentColor = Color.Black
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .testTag("resume_contact_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.size(6.dp))
                        Text(
                            text = "Contact Me",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp
                            )
                        )
                    }

                    OutlinedButton(
                        onClick = onShareClick,
                        shape = RoundedCornerShape(12.dp),
                        border = androidx.compose.foundation.BorderStroke(1.dp, Cyan400),
                        modifier = Modifier
                            .weight(1f)
                            .testTag("resume_share_bottom_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = null,
                            tint = Cyan400,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.size(6.dp))
                        Text(
                            text = "Share CV",
                            style = MaterialTheme.typography.titleMedium.copy(
                                color = Cyan400,
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ResumeSectionHeader(title: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(width = 16.dp, height = 2.dp)
                .background(Cyan400)
        )
        Text(
            text = title,
            style = MaterialTheme.typography.labelSmall.copy(
                color = Cyan400,
                fontWeight = FontWeight.Bold,
                fontSize = 11.sp,
                letterSpacing = 1.sp
            )
        )
    }
}

@Composable
fun ResumeSkillRow(label: String, items: String) {
    Column {
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall.copy(
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 11.sp
            )
        )
        Text(
            text = items,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Slate400,
                fontSize = 11.sp
            )
        )
    }
}
