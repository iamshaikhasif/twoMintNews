package com.example.twomintnews.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun NormalTextComponent(title: String) {
    Text(text = title, style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Normal))
}

@Composable
fun HeadingTextComponent(title: String) {
    Text(text = title, style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Medium))
}