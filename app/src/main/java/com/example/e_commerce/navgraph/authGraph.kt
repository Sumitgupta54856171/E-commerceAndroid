package com.example.e_commerce.navgraph

import androidx.compose.material3.Text
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.e_commerce.presentation.view.ui.authui.Login
import com.example.e_commerce.presentation.view.ui.authui.Sigin
import com.example.e_commerce.presentation.viewmodel.Loginviewmodel

fun NavGraphBuilder.auhthGraph(navController: NavController){
    navigation(
        route = "auth",
        startDestination = "login"
    ){
        composable("login"){
            Login(navController = navController)
        }
        composable("sigin"){
            Sigin(navController = navController)
        }
    }
}


