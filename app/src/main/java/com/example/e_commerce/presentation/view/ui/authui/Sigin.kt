package com.example.e_commerce.presentation.view.ui.authui

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import com.example.e_commerce.presentation.viewmodel.Loginviewmodel

@Composable
fun Sigin(
    viewModel: Loginviewmodel = hiltViewModel(),
    navController: NavController,

) {

    Box{
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(10.dp, top = 20.dp),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Create Your Account ", fontSize = 45.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal,
                color = Color.Black,
                modifier = Modifier
                    .padding(20.dp, bottom = 20.dp))
            Text(text="Experience the next generation of curated shopping",
                color = Color.DarkGray,
                fontSize = 18.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(bottom = 20.dp),


            )
            Spacer(modifier = Modifier.height(20.dp))
            Box(modifier = Modifier.shadow(elevation = 10.dp, shape = RoundedCornerShape(10.dp),clip = false).background(
                Color.White, RoundedCornerShape(10.dp)).padding(20.dp)){
                Column() {
                    Text(text="Username", color = Color.LightGray, fontSize = 20.sp ,fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(bottom = 8.dp, start = 4.dp)
                    )
                    TextField(
                        value = viewModel.username,
                        onValueChange = viewModel::onUsernamechange,
                        modifier = Modifier
                            .background(Color.White)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(percent = 20))
                            .border(2.dp, Color.DarkGray, RoundedCornerShape(10.dp)),
                        placeholder = { Text("Enter the username", color=Color.LightGray) },
                    )
                    Spacer(modifier = Modifier.height(20.dp))


                    Text(text="Email", color = Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(bottom = 6.dp, start = 4.dp)

                    )
                    TextField(
                        value = viewModel.email,
                        onValueChange = viewModel::onEmailchange,
                        modifier = Modifier
                            .background(Color.White)
                            .clip(RoundedCornerShape(percent = 10))
                            .fillMaxWidth()
                            .border(2.dp, Color.DarkGray, RoundedCornerShape(10.dp)),
                        placeholder = { Text(text="name@gmail.com") }
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text="password", color = Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(bottom = 6.dp, start = 4.dp)

                    )
                    TextField(
                        value = viewModel.password,
                        onValueChange = viewModel::onPasswordchange,
                        modifier = Modifier
                            .background(Color.White)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(percent = 10))
                            .border(2.dp, Color.DarkGray, RoundedCornerShape(10.dp)),
                        placeholder = { Text("Enter the password") },
                    )

                    Spacer(modifier = Modifier.height(20.dp))
                    Button(onClick = { viewModel.onregister(viewModel.username, viewModel.email, viewModel.password,viewModel.role) }, modifier = Modifier.fillMaxWidth().padding(top=20.dp, bottom = 20.dp),
                    ) {
                        Text(text = "Sign Up")
                    }
                }

            }


            Box(
                modifier = Modifier.padding(20.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Already have an account?")
                    Spacer(modifier = Modifier.width(20.dp))
                    Button(onClick = {
                       navController.navigate("login")


                    }) {
                        Text(text = "Login")
                    }
                }
            }
        }
    }
}

