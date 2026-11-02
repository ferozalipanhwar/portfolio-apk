package com.example.portfolio.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import com.example.portfolio.ui.theme.Blue600
import com.example.portfolio.ui.theme.Cyan400
import com.example.portfolio.ui.theme.Cyan500
import com.example.portfolio.ui.theme.Emerald400
import com.example.portfolio.ui.theme.Slate400
import com.example.portfolio.ui.theme.Slate700
import com.example.portfolio.ui.theme.Slate800
import com.example.portfolio.ui.theme.Slate900
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ContactSection(
    onSendEmailIntent: (String, String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var isSending by remember { mutableStateOf(false) }
    var showSuccessDialog by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val coroutineScope = rememberCoroutineScope()

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
                text = "GET IN TOUCH",
                style = MaterialTheme.typography.labelSmall.copy(
                    color = Cyan400,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.5.sp
                )
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            Text(
                text = "Let's Work ",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Black,
                    color = Color.White,
                    fontSize = 26.sp
                )
            )
            Text(
                text = "Together!",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Black,
                    brush = Brush.horizontalGradient(listOf(Cyan400, Blue600)),
                    fontSize = 26.sp
                )
            )
        }

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Have a project in mind or want to collaborate? Fill out the form or reach out directly.",
            style = MaterialTheme.typography.bodyMedium.copy(color = Slate400)
        )

        Spacer(modifier = Modifier.height(18.dp))

        // Direct contact cards
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            ContactInfoRow(
                icon = Icons.Default.Email,
                title = "Email",
                value = PortfolioData.EMAIL
            )
            ContactInfoRow(
                icon = Icons.Default.Phone,
                title = "Phone / WhatsApp",
                value = PortfolioData.PHONE
            )
            ContactInfoRow(
                icon = Icons.Default.LocationOn,
                title = "Location",
                value = PortfolioData.LOCATION
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Form Card
        Card(
            colors = CardDefaults.cardColors(containerColor = Slate900),
            shape = RoundedCornerShape(20.dp),
            border = androidx.compose.foundation.BorderStroke(1.dp, Slate800),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                Text(
                    text = "Send a Message",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )

                Spacer(modifier = Modifier.height(14.dp))

                // Name field
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Your Name") },
                    leadingIcon = {
                        Icon(Icons.Default.Person, contentDescription = null, tint = Cyan400)
                    },
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Cyan400,
                        unfocusedBorderColor = Slate700,
                        focusedLabelColor = Cyan400,
                        unfocusedLabelColor = Slate400,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        focusedContainerColor = Slate800,
                        unfocusedContainerColor = Slate800
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("contact_input_name")
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Email field
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Your Email") },
                    leadingIcon = {
                        Icon(Icons.Default.Email, contentDescription = null, tint = Cyan400)
                    },
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Cyan400,
                        unfocusedBorderColor = Slate700,
                        focusedLabelColor = Cyan400,
                        unfocusedLabelColor = Slate400,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        focusedContainerColor = Slate800,
                        unfocusedContainerColor = Slate800
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("contact_input_email")
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Message field
                OutlinedTextField(
                    value = message,
                    onValueChange = { message = it },
                    label = { Text("Project Details / Message") },
                    leadingIcon = {
                        Icon(Icons.Default.Message, contentDescription = null, tint = Cyan400)
                    },
                    minLines = 3,
                    maxLines = 5,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Cyan400,
                        unfocusedBorderColor = Slate700,
                        focusedLabelColor = Cyan400,
                        unfocusedLabelColor = Slate400,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        focusedContainerColor = Slate800,
                        unfocusedContainerColor = Slate800
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("contact_input_message")
                )

                if (errorMessage != null) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = errorMessage ?: "",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color(0xFFEF4444),
                            fontSize = 12.sp
                        )
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        if (name.isBlank() || email.isBlank() || message.isBlank()) {
                            errorMessage = "Please fill in all fields before sending."
                        } else {
                            errorMessage = null
                            isSending = true
                            coroutineScope.launch {
                                delay(1200) // Simulating network send
                                isSending = false
                                showSuccessDialog = true
                                onSendEmailIntent(name, email, message)
                                name = ""
                                email = ""
                                message = ""
                            }
                        }
                    },
                    enabled = !isSending,
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Cyan500,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("contact_submit_button")
                ) {
                    if (isSending) {
                        CircularProgressIndicator(
                            color = Color.Black,
                            modifier = Modifier.size(18.dp),
                            strokeWidth = 2.dp
                        )
                        Spacer(modifier = Modifier.size(8.dp))
                        Text("Transmitting...")
                    } else {
                        Icon(
                            imageVector = Icons.Default.Send,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.size(8.dp))
                        Text(
                            text = "Send Message",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp
                            )
                        )
                    }
                }
            }
        }
    }

    // Success Dialog
    if (showSuccessDialog) {
        AlertDialog(
            onDismissRequest = { showSuccessDialog = false },
            title = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = Emerald400,
                        modifier = Modifier.size(24.dp)
                    )
                    Text("Message Transmitted", color = Color.White)
                }
            },
            text = {
                Text(
                    text = "Thank you for reaching out! Your message has been sent to Feroz Ali Panhwar. I will get back to you shortly.",
                    color = Slate400,
                    fontSize = 14.sp
                )
            },
            confirmButton = {
                TextButton(
                    onClick = { showSuccessDialog = false },
                    modifier = Modifier.testTag("dismiss_contact_dialog")
                ) {
                    Text("OK", color = Cyan400, fontWeight = FontWeight.Bold)
                }
            },
            containerColor = Slate900,
            tonalElevation = 6.dp
        )
    }
}

@Composable
fun ContactInfoRow(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    value: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .background(Slate900.copy(alpha = 0.6f), RoundedCornerShape(10.dp))
            .border(1.dp, Slate800, RoundedCornerShape(10.dp))
            .padding(horizontal = 12.dp, vertical = 10.dp)
    ) {
        Box(
            modifier = Modifier
                .size(34.dp)
                .background(Cyan500.copy(alpha = 0.15f), RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Cyan400,
                modifier = Modifier.size(18.dp)
            )
        }
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.labelSmall.copy(
                    color = Slate400,
                    fontSize = 10.sp
                )
            )
            Text(
                text = value,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp
                )
            )
        }
    }
}
