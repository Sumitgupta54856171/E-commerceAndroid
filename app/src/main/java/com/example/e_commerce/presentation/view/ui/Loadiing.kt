package com.example.e_commerce.presentation.view.ui

import android.graphics.drawable.AnimatedImageDrawable
import androidx.compose.animation.core.AnimationVector
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimationVectorDrawable(){
    CircularProgressIndicator(
        color = Color.Green,
        strokeWidth = 10.dp
    )
}
