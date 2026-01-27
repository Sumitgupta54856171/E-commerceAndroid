package com.example.e_commerce.navgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.e_commerce.presentation.view.ui.home.HomeScreen
import com.example.e_commerce.presentation.view.ui.productui.ProductDetailScreen


fun NavGraphBuilder.mainGraph(navController: NavController){
    navigation(
        route="main",
        startDestination = "home"
    ){
        composable("home") {
            HomeScreen() // Use Composable instead of Activity
        }
        composable("catagory") {
            Text("Catalog Screen")
        }
        composable("cart") {
            Text("Profile Screen")
        }
        composable("order"){
            Text("Cart Screen")
        }
        composable (route = "profile"){
            Text("User Profile")
        }
        composable(route = "/product/{product_id}") {
            entry ->
            val product_id = entry.arguments?.getString("product_id")
            ProductDetailScreen(product_id = product_id)
        }
        composable(route = "search"){

        }
        composable(route = "search/{query}") {
            entry -> {
                val query = entry.arguments?.getString("query")

        }

        }

    }
}
