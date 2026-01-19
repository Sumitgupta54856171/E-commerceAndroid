package com.example.e_commerce.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomTab(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    object Home : BottomTab("home", "Home", Icons.Default.Home)
    object Search : BottomTab("search", "Search", Icons.Default.Search)
    object Profile : BottomTab("profile", "Profile", Icons.Default.Person)
}
