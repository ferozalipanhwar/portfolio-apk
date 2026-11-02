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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolio.data.PortfolioData
import com.example.portfolio.model.SkillCategory
import com.example.portfolio.model.SkillItem
import com.example.portfolio.ui.theme.Cyan400
import com.example.portfolio.ui.theme.Purple500
import com.example.portfolio.ui.theme.Slate400
import com.example.portfolio.ui.theme.Slate700
import com.example.portfolio.ui.theme.Slate800
import com.example.portfolio.ui.theme.Slate900

@Composable
fun SkillsSection(
    modifier: Modifier = Modifier
) {
    var selectedCategory by remember { mutableStateOf(SkillCategory.ALL) }

    val filteredSkills = remember(selectedCategory) {
        if (selectedCategory == SkillCategory.ALL) {
            PortfolioData.skills
        } else {
            PortfolioData.skills.filter { it.category == selectedCategory }
        }
    }

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
                text = "TECH STACK",
                style = MaterialTheme.typography.labelSmall.copy(
                    color = Cyan400,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.5.sp
                )
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "My Development Arsenal",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Black,
                color = Color.White,
                fontSize = 26.sp
            )
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Technologies and frameworks I utilize to build scalable, high-performance applications.",
            style = MaterialTheme.typography.bodyMedium.copy(color = Slate400)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Category filter chips
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            SkillCategory.entries.forEach { cat ->
                val isSelected = selectedCategory == cat
                val label = when (cat) {
                    SkillCategory.ALL -> "All"
                    SkillCategory.FRONTEND -> "Frontend"
                    SkillCategory.BACKEND -> "Backend"
                    SkillCategory.MOBILE -> "Mobile"
                    SkillCategory.TOOLS -> "Tools"
                }

                Box(
                    modifier = Modifier
                        .background(
                            color = if (isSelected) Cyan400 else Slate900,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .border(
                            width = 1.dp,
                            color = if (isSelected) Cyan400 else Slate700,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clickable { selectedCategory = cat }
                        .padding(horizontal = 10.dp, vertical = 6.dp)
                        .testTag("skill_chip_${cat.name.lowercase()}")
                ) {
                    Text(
                        text = label,
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = if (isSelected) Color.Black else Slate400,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                            fontSize = 11.sp
                        )
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Skills Grid in fixed height or layout
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            filteredSkills.chunked(2).forEach { rowSkills ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    rowSkills.forEach { skill ->
                        Box(modifier = Modifier.weight(1f)) {
                            SkillCardItem(skill = skill)
                        }
                    }
                    if (rowSkills.size == 1) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Composable
fun SkillCardItem(
    skill: SkillItem,
    modifier: Modifier = Modifier
) {
    val skillColor = Color(skill.colorHex)

    Card(
        colors = CardDefaults.cardColors(containerColor = Slate900.copy(alpha = 0.85f)),
        shape = RoundedCornerShape(14.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, Slate800),
        modifier = modifier
            .fillMaxWidth()
            .testTag("skill_card_${skill.name.lowercase().replace(" ", "_")}")
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .background(skillColor, CircleShape)
                    )
                    Text(
                        text = skill.name,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 13.sp
                        )
                    )
                }
                Text(
                    text = "${skill.proficiency}%",
                    style = MaterialTheme.typography.labelSmall.copy(
                        color = Cyan400,
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp
                    )
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            LinearProgressIndicator(
                progress = { skill.proficiency / 100f },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp),
                color = skillColor,
                trackColor = Slate800,
            )
        }
    }
}
