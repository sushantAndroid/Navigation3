package com.example.navigation3.persentation.view

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigation3.persentation.viewmodel.User


@Composable
fun SettingsBottomSheetContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Quick Settings",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            QuickSettingItem(
                icon = Icons.Default.Notifications,
                label = "Notifications",
                onClick = { /* Toggle notifications */ }
            )

            QuickSettingItem(
                icon = Icons.Default.Check,
                label = "Dark Mode",
                onClick = { /* Toggle dark mode */ }
            )

            QuickSettingItem(
                icon = Icons.Default.Email,
                label = "Language",
                onClick = { /* Change language */ }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun QuickSettingItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    onClick: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        Card(
            modifier = Modifier.size(56.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = label,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = label,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}


fun getSampleUsers(): List<User> {
    return listOf(
        User(
            id = "1",
            name = "Alice Johnson",
            email = "alice.johnson@example.com"
        ),
        User(
            id = "2",
            name = "Bob Smith",
            email = "bob.smith@example.com"
        ),
        User(
            id = "3",
            name = "Carol Davis",
            email = "carol.davis@example.com"
        ),
        User(
            id = "4",
            name = "David Wilson",
            email = "david.wilson@example.com"
        ),
        User(
            id = "5",
            name = "Eva Brown",
            email = "eva.brown@example.com"
        )
    )
}