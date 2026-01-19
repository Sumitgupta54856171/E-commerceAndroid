package com.example.e_commerce.presentation.view.ui.authui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.e_commerce.presentation.viewmodel.Loginviewmodel

val TealPrimary = Color(0xFF005F61)
val BackgroundLight = Color(0xFFF9FAFB)
val TextDark = Color(0xFF0C1C1D)
val BorderColor = Color(0xFFCDE9EA)
val PlaceholderColor = Color(0xFF9CA3AF)

@Composable
fun Login(viewModel: Loginviewmodel = hiltViewModel(), navController: NavController) {
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome to Login",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(20.dp))
            InputLabel("Email")
            TextField(
                value = viewModel.email,
                onValueChange = viewModel::onEmailchange,
                modifier = Modifier
                    .background(Color.White)
                    .clip(RoundedCornerShape(percent = 40))
                    .border(2.dp, Color.Green, RoundedCornerShape(20.dp)),
                placeholder = { Text("name@gmail.com") }
            )
            Spacer(modifier = Modifier.height(20.dp))
            InputLabel("Password")
            TextField(
                value = viewModel.password,
                onValueChange = viewModel::onPasswordchange,
                modifier = Modifier
                    .background(Color.White)
                    .clip(RoundedCornerShape(percent = 40))
                    .border(2.dp, Color.Green, RoundedCornerShape(20.dp)),
                placeholder = { Text("Enter the password") },
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { viewModel.onlogin(viewModel.password, viewModel.email) }) {
                Text(text = "Login")
            }

            Box {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Don't have an account?")
                    Button(onClick = {
                        navController.navigate("sigin")
                    }) {
                        Text(text = "Sign up")
                    }
                }
            }
        }
    }
}

@Composable
fun InputLabel(text: String) {
    Text(
        text = text,
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold,
        color = TextDark,
        modifier = Modifier
            .padding(bottom = 6.dp, start = 4.dp)
    )
}
