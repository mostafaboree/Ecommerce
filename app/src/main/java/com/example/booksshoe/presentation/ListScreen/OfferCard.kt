package com.example.booksshoe.presentation.ListScreen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.BookShoe.R

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CardOffer(){
val circlesize = animateDpAsState(targetValue = 16.dp, label = "")

val pagerState = rememberPagerState(
        pageCount = {
            3
        }
        , initialPage = 0
    )
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)) {

    HorizontalPager(state = pagerState,) {
page->

    CardOfferee(discountedPrice = 30.0)}

        Row(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(horizontal = if (pagerState.currentPage == iteration) 0.dp else  2.dp, vertical = 2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(10.dp))

            }}
    }
}

@Composable
fun CardOfferee( discountedPrice: Double,){
    Card (modifier = Modifier
        .fillMaxWidth()
        .height(180.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray
        )
    , shape = RoundedCornerShape(20.dp)
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(listOf(Color.DarkGray, Color.Black)))){

    Image(painter = painterResource(id = R.drawable.zare), contentDescription = "",
        modifier = Modifier
            .align(Alignment.TopEnd)
            .size(200.dp)
            .padding(top = 10.dp)
            .scale(1.1f),
        contentScale = androidx.compose.ui.layout.ContentScale.Crop,
        alignment = Alignment.TopEnd)
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp, end = 10.dp, top = 20.dp, bottom = 20.dp),
                verticalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Get Your Special Sale ".uppercase(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Start))
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.White,
                                fontSize = 30.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.Bold
                            ))
                    {
                        append("Up To ".uppercase())
                    }
                        withStyle(
                            style = SpanStyle(
                                color = Color.White,
                                fontSize = 50.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.Bold
                        ) ){
                                append(discountedPrice.toInt().toString()+"%")
                            }
                    })

                Button(onClick = { /*TODO*/ },colors = androidx.compose.material3.ButtonDefaults.buttonColors(containerColor = Color.White))
                {
                    Text(text = "Shop Now".uppercase(),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Cursive,
                        color = Color.Black)
                }
            }
    }
    }



}