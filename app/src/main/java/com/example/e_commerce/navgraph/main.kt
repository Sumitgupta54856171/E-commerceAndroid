package com.example.e_commerce.navgraph

import androidx.compose.material3.Text
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.mainGraph(navController: NavController){
    navigation(
        route="main",
        startDestination = "home"
    ){
        composable("home") {
            Text("Home Screen") // Use Composable instead of Activity
        }
        composable("catalog") {
            Text("Catalog Screen")
        }
        composable("cart"){
            Text("Cart Screen")
        }
        composable("order") {
            Text("Order Screen")
        }
        composable("Account"){
            Text("Account Screen")
        }
    }
}
