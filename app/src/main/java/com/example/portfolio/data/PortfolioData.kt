package com.example.portfolio.data

import com.example.portfolio.model.BlogItem
import com.example.portfolio.model.ExperienceItem
import com.example.portfolio.model.GalleryItem
import com.example.portfolio.model.ProjectItem
import com.example.portfolio.model.SkillCategory
import com.example.portfolio.model.SkillItem

object PortfolioData {
    const val AUTHOR_NAME = "Feroz Ali Panhwar"
    const val ROLE_TITLE = "Full Stack & React Native Developer"
    const val BIO_SUMMARY = "Hi! I am Feroz Ali Panhwar, a dedicated Full Stack & Mobile Developer from Pakistan. I specialize in building digital experiences that are not just functional but also visually stunning. My code solves real-world problems with a focus on performance and scalability."
    const val LOCATION = "Sindh, Pakistan"
    const val EMAIL = "panhwarcode@gmail.com"
    const val PHONE = "+92 325 6749757"
    const val WHATSAPP_URL = "https://wa.me/923256749757"
    const val GITHUB_URL = "https://github.com/ferozalipanhwar"
    const val LINKEDIN_URL = "https://linkedin.com/in/ferozalipanhwar"

    val skills = listOf(
        SkillItem("React", SkillCategory.FRONTEND, 95, 0xFF61DBFB, "react"),
        SkillItem("Next.js", SkillCategory.FRONTEND, 90, 0xFFFFFFFF, "nextjs"),
        SkillItem("React Native", SkillCategory.MOBILE, 92, 0xFF61DBFB, "react_native"),
        SkillItem("TypeScript", SkillCategory.FRONTEND, 88, 0xFF3178C6, "typescript"),
        SkillItem("JavaScript", SkillCategory.FRONTEND, 95, 0xFFF0DB4F, "javascript"),
        SkillItem("HTML5", SkillCategory.FRONTEND, 98, 0xFFE44D26, "html5"),
        SkillItem("CSS3 / Tailwind", SkillCategory.FRONTEND, 96, 0xFF38B2AC, "tailwind"),
        SkillItem("Node.js", SkillCategory.BACKEND, 88, 0xFF68A063, "nodejs"),
        SkillItem("Express", SkillCategory.BACKEND, 85, 0xFFFFFFFF, "express"),
        SkillItem("MongoDB", SkillCategory.BACKEND, 82, 0xFF4DB33D, "mongodb"),
        SkillItem("Firebase", SkillCategory.BACKEND, 85, 0xFFFFCA28, "firebase"),
        SkillItem("Python", SkillCategory.BACKEND, 80, 0xFF306998, "python"),
        SkillItem("Java", SkillCategory.BACKEND, 75, 0xFFF89820, "java"),
        SkillItem("PHP", SkillCategory.BACKEND, 78, 0xFF8993BE, "php"),
        SkillItem("Git & GitHub", SkillCategory.TOOLS, 90, 0xFFF05032, "git")
    )

    val experiences = listOf(
        ExperienceItem(
            title = "Senior React Developer",
            company = "Tech Solutions Inc.",
            date = "2023 - Present",
            description = "Leading the frontend engineering team, architecting scalable enterprise web applications using React, Next.js, and modern state management. Optimized client render cycles by 40%.",
            highlights = listOf(
                "Engineered responsive components with 60fps animations",
                "Reduced build and bundle payload sizes by 35%",
                "Mentored junior developers on TypeScript and modern design patterns"
            )
        ),
        ExperienceItem(
            title = "Full Stack Developer",
            company = "Creative Agency",
            date = "2021 - 2023",
            description = "Developed end-to-end full-stack solutions using the MERN stack. Designed normalized MongoDB data schemas, REST APIs, and integrated third-party payment gateways.",
            highlights = listOf(
                "Implemented secure JWT authentication and role-based access",
                "Optimized database queries reducing API latency by 40%",
                "Built custom admin management dashboards"
            )
        ),
        ExperienceItem(
            title = "Junior Web Developer",
            company = "Startup Hub",
            date = "2020 - 2021",
            description = "Collaborated with UI/UX designers to translate Figma design mockups into pixel-perfect responsive web pages. Fixed cross-browser bugs and maintained legacy codebases.",
            highlights = listOf(
                "Developed 20+ responsive landing pages and portals",
                "Wrote modular, reusable CSS and JavaScript utility modules",
                "Assisted with QA testing and production deployments"
            )
        )
    )

    val projects = listOf(
        ProjectItem(
            id = "alif-akh",
            title = "Alif Akh Academy",
            description = "A complete Learning Management System (LMS) for online education. Features include student portals, course tracking, dynamic video delivery, and online interactive testing.",
            tags = listOf("MERN Stack", "LMS", "Education", "Stripe"),
            link = "https://alifakhacademy.online",
            imageUrl = "https://images.unsplash.com/photo-1501504905252-473c47e087f8?q=80&w=1074&auto=format&fit=crop",
            category = "Web"
        ),
        ProjectItem(
            id = "autaaq",
            title = "Autaaq",
            description = "A cultural social media platform with a distinctive 'Sindhi Touch'. Connects communities with localized feeds, vernacular audio sharing, and community gatherings.",
            tags = listOf("React Native", "Social Media", "Firebase", "Community"),
            link = "https://github.com/ferozalipanhwar",
            imageUrl = "https://images.unsplash.com/photo-1529156069898-49953e39b3ac?q=80&w=1000&auto=format&fit=crop",
            category = "Mobile"
        ),
        ProjectItem(
            id = "easydocs",
            title = "EasyDocs",
            description = "Smart attendance and document verification system using dynamic QR Codes. Students scan rotating codes for instant verification, streamlining classroom management.",
            tags = listOf("QR Tech", "Mobile App", "Admin Panel", "Node.js"),
            link = "https://github.com/ferozalipanhwar",
            imageUrl = "https://images.unsplash.com/photo-1551836022-d5d88e9218df?q=80&w=1000&auto=format&fit=crop",
            category = "Mobile"
        ),
        ProjectItem(
            id = "agriculture-app",
            title = "Agriculture App",
            description = "A localized digital assistant for 'Kissan' (farmers). Helps farmers communicate, diagnose crop health via image scanning, and get real-time weather alerts in local languages.",
            tags = listOf("AgriTech", "Localization", "Weather API", "Community"),
            link = "https://github.com/ferozalipanhwar",
            imageUrl = "https://images.unsplash.com/photo-1625246333195-78d9c38ad449?q=80&w=1000&auto=format&fit=crop",
            category = "Mobile"
        ),
        ProjectItem(
            id = "share-ride",
            title = "Share Ride",
            description = "A carpooling and ride-sharing solution for commuters. Connects verified drivers with passengers along common routes to reduce travel costs and vehicular emissions.",
            tags = listOf("Maps API", "Real-time", "Travel", "Sockets"),
            link = "https://github.com/ferozalipanhwar",
            imageUrl = "https://images.unsplash.com/photo-1449965408869-eaa3f722e40d?q=80&w=1000&auto=format&fit=crop",
            category = "Mobile"
        ),
        ProjectItem(
            id = "fast-food-store",
            title = "Fast Food Store",
            description = "A dynamic e-commerce app for food ordering and express delivery. Features real-time order tracking, live kitchen status, customized menus, and digital wallet checkout.",
            tags = listOf("E-commerce", "Redux", "Stripe", "Delivery"),
            link = "https://github.com/ferozalipanhwar",
            imageUrl = "https://images.unsplash.com/photo-1561758033-d89a9ad46330?q=80&w=1000&auto=format&fit=crop",
            category = "Web"
        ),
        ProjectItem(
            id = "uc-complaint",
            title = "UC Complaint System",
            description = "A municipal governance management portal for tracking and resolving citizen complaints at the Union Council level, featuring automated escalation workflows.",
            tags = listOf("GovTech", "Management", "Reporting", "Civic"),
            link = "https://github.com/ferozalipanhwar",
            imageUrl = "https://images.unsplash.com/photo-1486406146926-c627a92ad1ab?q=80&w=1000&auto=format&fit=crop",
            category = "System"
        ),
        ProjectItem(
            id = "voice-cart",
            title = "Voice Cart",
            description = "A voice-enabled, accessible e-commerce platform specially tailored for visually impaired persons. Allows full shopping navigation, cart management, and payment using speech commands.",
            tags = listOf("Voice AI", "Accessibility", "E-commerce", "Web Speech"),
            link = "https://github.com/ferozalipanhwar",
            imageUrl = "https://images.unsplash.com/photo-1516321318423-f06f85e504b3?q=80&w=1000&auto=format&fit=crop",
            category = "Web"
        )
    )

    val blogs = listOf(
        BlogItem(
            id = "mastering-mern-stack",
            title = "Mastering the MERN Stack: A Comprehensive Guide",
            date = "September 1, 2024",
            readTime = "6 min read",
            excerpt = "Explore the fundamentals of MongoDB, Express, React, and Node.js to architect high-performance full-stack web applications with modern best practices.",
            content = "The MERN stack (MongoDB, Express.js, React.js, Node.js) remains one of the most powerful and flexible full-stack JavaScript architectures in contemporary software engineering.\n\n### 1. Unified Language Ecosystem\nBy utilizing JavaScript across the entire stack, developers eliminate context-switching between languages. Data models written in JSON transition smoothly from database storage through API transport directly to UI components.\n\n### 2. State & Component Driven Architecture\nReact's virtual DOM and reactive hooks provide predictive rendering. Combined with custom hooks and query managers like TanStack Query, server state synchronization becomes clean and robust.\n\n### 3. Scalable Express Architecture\nStructuring Express middleware into isolated controllers, services, and repository layers ensures that business logic remains testable and maintainable as the project expands.",
            tags = listOf("React", "Node.js", "MongoDB", "Express"),
            imageUrl = "https://images.unsplash.com/photo-1555066931-4365d14bab8c?q=80&w=1000&auto=format&fit=crop"
        ),
        BlogItem(
            id = "cross-platform-react-native",
            title = "Building High-Performance Cross-Platform Apps with React Native",
            date = "August 15, 2024",
            readTime = "5 min read",
            excerpt = "Learn how to create high-performance mobile applications with native feel across iOS and Android from a single shared codebase.",
            content = "React Native has matured substantially with the New Architecture, TurboModules, and Fabric renderer. Today, cross-platform mobile development matches native performance while cutting delivery timelines in half.\n\n### 1. Memory Management & FlatLists\nWhen dealing with extensive feeds, fine-tuning `initialNumToRender`, `maxToRenderPerBatch`, and utilizing `getItemLayout` prevents memory spikes and maintains smooth scrolling.\n\n### 2. Native Bridge Optimization\nWith JSI (JavaScript Interface), JavaScript communicates directly with C++ host objects without asynchronous JSON serialization, providing instant gesture responses.",
            tags = listOf("React Native", "Mobile", "Performance", "Cross-Platform"),
            imageUrl = "https://images.unsplash.com/photo-1512941937669-90a1b58e7e9c?q=80&w=1000&auto=format&fit=crop"
        ),
        BlogItem(
            id = "java-vs-python",
            title = "Java vs. Python: Choosing the Right Tool for the Job",
            date = "July 25, 2024",
            readTime = "7 min read",
            excerpt = "An engineering comparison of Java and Python: analyzing execution performance, ecosystem maturity, and strategic application scenarios.",
            content = "Choosing between Java and Python is not about which language is objectively superior, but which delivers the right tradeoffs for your specific problem domain.\n\n### When to Choose Java:\n- Enterprise banking, telecom, and transaction backends requiring strict compile-time type safety.\n- High-throughput concurrency with Virtual Threads (Project Loom).\n- Native Android development and long-lifecycle enterprise systems.\n\n### When to Choose Python:\n- Rapid prototyping, data science, and AI/ML model orchestration.\n- Microservices utilizing FastAPI with async IO.\n- Automated scripting, web scraping, and developer tooling.",
            tags = listOf("Java", "Python", "Architecture", "Backend"),
            imageUrl = "https://images.unsplash.com/photo-1526374965328-7f61d4dc18c5?q=80&w=1000&auto=format&fit=crop"
        ),
        BlogItem(
            id = "mern-chat-application",
            title = "Creating a Real-Time Chat Application with WebSockets",
            date = "June 30, 2024",
            readTime = "8 min read",
            excerpt = "Step-by-step engineering insights on constructing a real-time messaging engine with end-to-end socket events and message persistence.",
            content = "Real-time communication requires bidirectional, low-latency streaming between client and server. Socket.IO and native WebSockets handle heartbeat connections and room isolation seamlessly.\n\nKey pillars include handling connection drops gracefully, optimistic UI message updates with client-generated UUIDs, and background offline queuing.",
            tags = listOf("WebSockets", "Node.js", "Real-Time", "Chat"),
            imageUrl = "https://images.unsplash.com/photo-1618005182384-a83a8bd57fbe?q=80&w=1000&auto=format&fit=crop"
        ),
        BlogItem(
            id = "clean-javascript-code",
            title = "Writing Clean, Resilient, and Maintainable JavaScript",
            date = "May 20, 2024",
            readTime = "4 min read",
            excerpt = "Essential programming conventions, functional patterns, and structural habits every modern web engineer should follow.",
            content = "Clean code is self-documenting code. Favoring pure functions, descriptive identifier naming, defensive null handling with optional chaining (`?.`), and immutable data updates ensures codebases scale without technical debt.",
            tags = listOf("JavaScript", "Best Practices", "Clean Code"),
            imageUrl = "https://images.unsplash.com/photo-1461749280684-dccba630e2f6?q=80&w=1000&auto=format&fit=crop"
        ),
        BlogItem(
            id = "python-web-development",
            title = "Why Python is a Premier Choice for Modern Web Development",
            date = "April 10, 2024",
            readTime = "5 min read",
            excerpt = "Unpacking the power of Python web frameworks like Django, Flask, and FastAPI for building modern, scalable APIs.",
            content = "Python's batteries-included philosophy and rich package ecosystem make it a top contender for modern backend development. FastAPI in particular brings automatic OpenAPI generation and native Pydantic validation.",
            tags = listOf("Python", "FastAPI", "Django", "Web Dev"),
            imageUrl = "https://images.unsplash.com/photo-1504639725590-34d0984388bd?q=80&w=1000&auto=format&fit=crop"
        )
    )

    val galleryItems = listOf(
        GalleryItem(
            id = 1,
            title = "Workspace Setup",
            description = "Dual-monitor ergonomic development cockpit with mechanical switches and ambient bias lighting.",
            imageUrl = "https://images.unsplash.com/photo-1492724441997-5dc865305da7?q=80&w=2070&auto=format&fit=crop"
        ),
        GalleryItem(
            id = 2,
            title = "Coding in Action",
            description = "Active full-stack development session debugging async streams and UI components.",
            imageUrl = "https://images.unsplash.com/photo-1498050108023-c5249f4df085?q=80&w=2072&auto=format&fit=crop"
        ),
        GalleryItem(
            id = 3,
            title = "Code Review",
            description = "Collaborative GitHub pull request audit ensuring architectural compliance and test coverage.",
            imageUrl = "https://images.unsplash.com/photo-1555066931-4365d14bab8c?q=80&w=2070&auto=format&fit=crop"
        ),
        GalleryItem(
            id = 4,
            title = "Late Night Sprints",
            description = "Focused late-night engineering sprint shipping key feature releases and deployments.",
            imageUrl = "https://images.unsplash.com/photo-1517694712202-14dd9538aa97?q=80&w=2070&auto=format&fit=crop"
        ),
        GalleryItem(
            id = 5,
            title = "Team Collaboration",
            description = "Remote whiteboarding and technical architecture breakdown for client deliverables.",
            imageUrl = "https://images.unsplash.com/photo-1522071820081-009f0129c71c?q=80&w=2070&auto=format&fit=crop"
        ),
        GalleryItem(
            id = 6,
            title = "Creative Desk",
            description = "Clean minimalist workstation optimized for deep work, note taking, and conceptual design.",
            imageUrl = "https://images.unsplash.com/photo-1504384308090-c894fdcc538d?q=80&w=2070&auto=format&fit=crop"
        )
    )
}
