package com.example.e_commerce.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomTab(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    object Home : BottomTab("home", "Home", Icons.Default.Home)
    object Search : BottomTab("catagory", "Catagory", Icons.Filled.Category)

    object Cart : BottomTab(route = "cart", label = "Cart",Icons.Filled.AddShoppingCart)

    object Order : BottomTab(route = "order", label = "Order",Icons.Filled.ShoppingCart)
    object Profile : BottomTab("profile", "Profile", Icons.Default.Person)

}
