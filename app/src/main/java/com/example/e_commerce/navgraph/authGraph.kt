package com.example.e_commerce.navgraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.e_commerce.presentation.view.ui.authui.Login
import com.example.e_commerce.presentation.view.ui.authui.Sigin
import com.example.e_commerce.presentation.viewmodel.Loginviewmodel

import com.example.e_commerce.presentation.view.LoginActivity
import com.example.e_commerce.presentation.view.SiginActivity

fun NavGraphBuilder.auhthGraph(navController: NavController){
    navigation(
        route = "auth",
        startDestination = "login"
    ){
        composable("login"){
        LoginActivity()
        }
        composable("sigin"){
            SiginActivity()
        }
    }
}


