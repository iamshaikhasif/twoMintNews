package com.example.twomintnews.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.example.twomintnews.R

val Roboto = FontFamily(
    Font(R.font.roboto_regular, FontWeight.Normal),
    Font(R.font.roboto_bold, FontWeight.Bold)
)

@Composable
fun NormalTextComponent(title: String) {
    Text(text = title, style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Normal, fontFamily = Roboto))
}

@Composable
fun SmallTextComponent(title: String) {
    Text(text = title, style = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.Normal, fontFamily = Roboto))
}

@Composable
fun HeadingTextComponent(title: String) {
    Text(text = title, style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Medium, fontFamily = Roboto))
}