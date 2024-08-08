package com.example.booksshoe.representation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedIconToggleButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.booksshoe.ui.theme.Typography
import com.example.eCommerce.R


@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun StartScreen(onclick: () -> Unit,navController: NavController) {
BoxWithConstraints (modifier = Modifier
    .fillMaxSize()
    .background(brush = Brush.linearGradient(listOf(Color.Black, Color.DarkGray)))
    ) {

        Image(painter = painterResource(id = R.drawable.start), contentDescription = "",
            modifier = Modifier.padding(20.dp)
                .clip(RoundedCornerShape(bottomStart = 100.dp))
                .fillMaxWidth()
                .fillMaxHeight(0.7f),
            contentScale = androidx.compose.ui.layout.ContentScale.Fit
            )
    Column(verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter)
            .fillMaxHeight(.35f)){
    Text(modifier = Modifier

        .fillMaxWidth()
        .padding(  10.dp),
        textAlign = TextAlign.Center,

        text = buildAnnotatedString {
            withStyle(
                 style = SpanStyle(
                     color = Color.White,
                     fontWeight = FontWeight.W800,
                     fontFamily = FontFamily.SansSerif,
                     fontSize = 35.sp,
                 )
                 ){
                append("GET READY TO DRESS YOUR LITTLE ONES      ")
            }
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 12.sp
                )
            ){
                append(" Discover trend outfits today!,Explore the best Product")
            }


        }
    )}
Button(onClick =onclick ,modifier = Modifier
    .fillMaxWidth()
    .align(Alignment.BottomCenter)
    .padding(20.dp)) {
    Text(text = "Get Started", fontSize = 20.sp, fontWeight = FontWeight.Bold,
        fontFamily = androidx.compose.ui.text.font.FontFamily.Serif,
        modifier = Modifier.padding(vertical = 10.dp))

    
}

    }
}