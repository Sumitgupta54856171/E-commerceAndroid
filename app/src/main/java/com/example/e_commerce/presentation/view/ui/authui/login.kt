package com.example.e_commerce.presentation.view.ui.authui

import android.media.Image
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel


import androidx.navigation.NavController
import com.example.e_commerce.R
import com.example.e_commerce.presentation.viewmodel.Loginviewmodel

val TealPrimary = Color(0xFF005F61)
val BackgroundLight = Color(0xFFF9FAFB)
val TextDark = Color(0xFF0C1C1D)
val BorderColor = Color(0xFFCDE9EA)
val PlaceholderColor = Color(0xFF9CA3AF)

@Composable
fun Login(viewModel: Loginviewmodel = hiltViewModel(), navController: NavController) {
    val isvalid = viewModel.authdata.collectAsState()
    val loading = viewModel._loading

    Box {

        if(!loading) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(10.dp),

                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(text="Login",fontSize = 25.sp, fontWeight = FontWeight.Bold,color = Color.Black,
                    modifier = Modifier.padding(bottom = 40.dp)
                    )
                Text(
                    text = "Welcome Back",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(20.dp, bottom = 20.dp)
                )
                Text(text="Sign in to continue your shopping journey",
                    color = Color.Gray,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(bottom = 30.dp)

                )

                Text(text="Email", color = Color.Black, fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 6.dp, start = 4.dp)
                        .align(Alignment.Start)
                )
                TextField(
                    value = viewModel.email,
                    onValueChange = viewModel::onEmailchange,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(percent = 40))
                        .border(2.dp, Color.Gray, RoundedCornerShape(20.dp)),
                    placeholder = { Text("name@gmail.com") }
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text("Password",color = Color.Black, fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 6.dp, start = 4.dp)
                        .align(Alignment.Start))
                TextField(
                    value = viewModel.password,
                    onValueChange = viewModel::onPasswordchange,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier
                        .background(Color.White)
                        .align(Alignment.Start)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(percent = 40))
                        .border(2.dp, Color.Gray, RoundedCornerShape(20.dp)),
                    placeholder = { Text("Enter the password") },
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Forgot Password?",
                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                        .padding(bottom = 30.dp)
                        .align(Alignment.End))
                Button(onClick = { viewModel.onlogin(viewModel.password, viewModel.email) }, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Login")
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Left Line
                    HorizontalDivider(
                        modifier = Modifier.weight(1f),
                        thickness = 1.dp,
                        color = Color.Gray
                    )

                    // Middle Text
                    Text(
                        text = "or continue with",
                        modifier = Modifier.padding(horizontal = 16.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )

                    // Right Line
                    HorizontalDivider(
                        modifier = Modifier.weight(1f),
                        thickness = 1.dp,
                        color = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = { /* Handle Login */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    border = BorderStroke(1.dp, Color.LightGray),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Sign in with Google",
                            color = Color.Black
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Box {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "Don't have an account?")
                        Spacer(modifier = Modifier.width(10.dp))
                        Button(onClick = {
                            navController.navigate("sigin")
                        }) {
                            Text(text = "Sign up")
                        }
                    }
                }
            }
        }else{
            CircularProgressIndicator(
                color = Color.Green,
                strokeWidth = 10.dp
            )
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

@Preview
@Composable
fun LoginPreview() {
    Login(viewModel = hiltViewModel(), navController = NavController(LocalContext.current))
}

