package com.example.portfolio.model

enum class SkillCategory {
    ALL, FRONTEND, BACKEND, MOBILE, TOOLS
}

data class SkillItem(
    val name: String,
    val category: SkillCategory,
    val proficiency: Int, // 0 - 100
    val colorHex: Long,
    val iconName: String
)

data class ExperienceItem(
    val title: String,
    val company: String,
    val date: String,
    val description: String,
    val highlights: List<String> = emptyList()
)

data class ProjectItem(
    val id: String,
    val title: String,
    val description: String,
    val tags: List<String>,
    val link: String,
    val githubUrl: String = "https://github.com/ferozalipanhwar",
    val imageUrl: String,
    val category: String
)

data class BlogItem(
    val id: String,
    val title: String,
    val date: String,
    val readTime: String,
    val excerpt: String,
    val content: String,
    val tags: List<String>,
    val imageUrl: String
)

data class GalleryItem(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String
)
