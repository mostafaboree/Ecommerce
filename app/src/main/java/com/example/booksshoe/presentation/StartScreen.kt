package com.example.booksshoe.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Divider
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.BookShoe.R


@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun StartScreen(navController: NavController, onclick: () -> Unit) {
BoxWithConstraints (modifier = Modifier
    .fillMaxSize()
    .background(brush = Brush.linearGradient(listOf(Color.Black, Color.DarkGray)))
    ) {

        Image(painter = painterResource(id = R.drawable.start), contentDescription = "",
            modifier = Modifier
                .padding(20.dp)
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
        .padding(10.dp),
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
@SuppressLint("UnusedBoxWithConstraintsScope")
@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    val textMeasurer = rememberTextMeasurer()

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        Color.DarkGray,
                        Color.Black,
                        Color.Black
                    )
                )
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.fashion), contentDescription = "",
            modifier = Modifier
                .padding(20.dp)

                .clip(RoundedCornerShape(bottomStart = 100.dp))
                .fillMaxWidth()
                .scale(1.6f)
                .fillMaxHeight(0.7f),
            alignment = Alignment.Center,
            contentScale = androidx.compose.ui.layout.ContentScale.Fit
        )
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .fillMaxHeight(.40f)
        ) {
            Text(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
                textAlign = TextAlign.Start,
                            color = Color.White,
                style = TextStyle(brush = Brush.verticalGradient(listOf(Color.White,Color.LightGray))),

                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Serif,
                            fontSize = 50.sp,
                lineHeight = 50.sp,
                        text = "Discover" +
                                " \n" +
                                "your style      ")
            Divider(modifier = Modifier,
                color = Color.Gray,
                thickness = 1.dp,
                startIndent = 150.dp
            )
            Text(text = "let's express your style with your clothes",
                modifier = Modifier.fillMaxWidth().padding( 20.dp),
                textAlign = TextAlign.Start,
                lineHeight = 30.sp,
                style = TextStyle(brush = Brush.verticalGradient(
                    listOf(
                        Color.White,
                        Color.LightGray
                    )
                )),
                color = Color.Gray,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp)





            // Draw the brush strokes on top

        }



        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color.LightGray)
            ,
            modifier = Modifier
                .fillMaxWidth(.6f)
                .align(Alignment.BottomEnd)
                .padding(20.dp)
        ) {
            Text(
                text = "Get Started", fontSize = 20.sp, fontWeight = FontWeight.ExtraLight,
                fontFamily = androidx.compose.ui.text.font.FontFamily.Serif,
                color = Color.Black,
                modifier = Modifier.padding(vertical = 10.dp)
            )


        }
}}