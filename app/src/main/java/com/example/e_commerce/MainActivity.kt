package com.example.e_commerce

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost

import androidx.navigation.compose.rememberNavController
import com.example.e_commerce.presentation.view.ui.BottomBar

import com.example.e_commerce.presentation.viewmodel.Loginviewmodel
import com.example.e_commerce.utils.SecureTokenManager
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.e_commerce.api.Api
import com.example.e_commerce.navgraph.auhthGraph
import com.example.e_commerce.navgraph.mainGraph
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
@HiltAndroidApp
class MainActivity : ComponentActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        val tokenManager = SecureTokenManager(this)
        val token = tokenManager.getToken() ?: ""
        
        setContent {
            val viewModel: Loginviewmodel = hiltViewModel()
            val navController = rememberNavController()
            val isvalid = viewModel.authdata.collectAsState()
            
            LaunchedEffect(Unit) {
                if (token.isNotEmpty()) {
                    viewModel.onauth(token)
                }
            }

            Scaffold(
                bottomBar = {
                    if (isvalid.value) {
                        BottomBar(navController)
                    }
                }
            ) { padding ->
                NavHost(
                    navController = navController,
                    startDestination = if (isvalid.value) "main" else "auth",
                    modifier = Modifier.padding(padding)
                ) {
                    mainGraph(navController)
                    auhthGraph(navController)
                }
            }
        }
    }
}
