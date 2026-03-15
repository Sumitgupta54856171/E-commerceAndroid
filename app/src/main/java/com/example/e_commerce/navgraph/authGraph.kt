package com.example.e_commerce.navgraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.e_commerce.presentation.view.ui.authui.Login
import com.example.e_commerce.presentation.view.ui.authui.Sigin

fun NavGraphBuilder.auhthGraph(navController: NavController){
    navigation(
        route = "auth",
        startDestination = "login"
    ){
        composable("login"){
            Login(navController = navController)
        }
        composable("sigin"){
            Sigin(navController = navController,)
        }
    }
}


