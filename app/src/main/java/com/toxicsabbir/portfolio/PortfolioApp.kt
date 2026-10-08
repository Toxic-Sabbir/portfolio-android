package com.toxicsabbir.portfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.toxicsabbir.portfolio.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PortfolioTheme {
                PortfolioScreen()
            }
        }
    }
}

@Composable
fun PortfolioScreen() {
    val profile = portfolioProfile()
    val context = LocalContext.current

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            contentPadding = PaddingValues(vertical = 20.dp)
        ) {
            item {
                HeaderCard(profile = profile, context = context)
            }

            item {
                AboutSection(profile = profile)
            }

            item {
                SectionTitle("Core Skills")
                SkillsRow(profile.skills)
            }

            item {
                SectionTitle("Featured Projects")
            }

            items(profile.projects) { project ->
                ProjectCard(project = project)
            }

            item {
                ContactSection(profile = profile, context = context)
            }
        }
    }
}

@Composable
private fun HeaderCard(profile: PortfolioProfile, context: LocalContext) {
    val gradient = Brush.linearGradient(
        listOf(
            MaterialTheme.colorScheme.primary,
            Accent,
            MaterialTheme.colorScheme.tertiary
        )
    )

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Surface)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(brush = gradient)
                .padding(20.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(18.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(72.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF111827)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "TS",
                            color = Color.White,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Button(
                        onClick = {
                            openUrl(context, "https://github.com/Toxic-Sabbir")
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(alpha = 0.15f))
                    ) {
                        Text(text = "GitHub")
                    }
                }

                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        text = profile.name,
                        style = MaterialTheme.typography.headlineLarge,
                        color = Color.White
                    )
                    Text(
                        text = profile.handle,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White.copy(alpha = 0.9f)
                    )
                    Text(
                        text = profile.title,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White.copy(alpha = 0.88f)
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    ActionChip(label = "Portfolio")
                    ActionChip(label = "Open to build")
                }
            }
        }
    }
}

@Composable
private fun AboutSection(profile: PortfolioProfile) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = Surface)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "About",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = profile.bio,
                style = MaterialTheme.typography.bodyLarge,
                color = SoftText
            )
        }
    }
}

@Composable
private fun SkillsRow(skills: List<String>) {
    FlowRow(horizontalGap = 8.dp, verticalGap = 8.dp) {
        skills.forEach { skill ->
            Surface(
                color = Accent.copy(alpha = 0.15f),
                shape = RoundedCornerShape(999.dp)
            ) {
                Text(
                    text = skill,
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
private fun ProjectCard(project: ProjectItem) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Surface)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = project.name,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = project.description,
                style = MaterialTheme.typography.bodyMedium,
                color = SoftText
            )
            FlowRow(horizontalGap = 6.dp, verticalGap = 6.dp) {
                project.techStack.forEach { tag ->
                    Surface(
                        color = Color.White.copy(alpha = 0.06f),
                        shape = RoundedCornerShape(999.dp)
                    ) {
                        Text(
                            text = tag,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ContactSection(profile: PortfolioProfile, context: LocalContext) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = Surface)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Contact",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface
            )

            profile.socialLinks.forEach { link ->
                val icon = when (link.label) {
                    "GitHub" -> Icons.Default.Language
                    "Email" -> Icons.Default.Email
                    else -> Icons.Default.Work
                }

                val trailing = if (link.label == "Email") "mailto:toxicsabbir.dev@gmail.com" else link.url

                ElevatedButton(
                    onClick = { openUrl(context, trailing) },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.elevatedButtonColors(containerColor = Color.White.copy(alpha = 0.04f))
                ) {
                    Icon(icon, contentDescription = link.label)
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(link.label)
                }
            }
        }
    }
}

@Composable
private fun SectionTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.onSurface,
        modifier = Modifier.padding(bottom = 4.dp)
    )
}

@Composable
private fun ActionChip(label: String) {
    Surface(
        color = Color.White.copy(alpha = 0.12f),
        shape = RoundedCornerShape(999.dp)
    ) {
        Text(
            text = label,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            style = MaterialTheme.typography.labelLarge,
            color = Color.White
        )
    }
}

private fun openUrl(context: android.content.Context, url: String) {
    val intent = android.content.Intent(android.content.Intent.ACTION_VIEW, android.net.Uri.parse(url))
    context.startActivity(intent)
}
