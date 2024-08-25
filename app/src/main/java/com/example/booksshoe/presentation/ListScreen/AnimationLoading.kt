package com.example.booksshoe.presentation.ListScreen

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LoadingItem(modifier: Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)

    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .ShimmerloadingAnimation(),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .ShimmerloadingAnimation(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .fillMaxHeight(.7f)
                        .background(Color.LightGray, shape = RoundedCornerShape(10.dp))
                        .clip(RoundedCornerShape(10.dp))
                        .ShimmerloadingAnimation()
                        .clip(RoundedCornerShape(20.dp))
                )
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = modifier
                        .padding(10.dp)
                        .fillMaxWidth(1f)
                        .fillMaxHeight(1f)
                        .background(
                            color = Color.LightGray,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .clip(RoundedCornerShape(10.dp))
                        .ShimmerloadingAnimation()
                )


            }
        }

    }
}
fun Modifier.ShimmerloadingAnimation(
    animationDuration: Int = 1000,
    angleofAxisY: Float = 270f,
    widthOfBrush : Float = 300f
): Modifier {
    return composed{
        val shimmerColor = listOf(
            Color.White.copy(alpha = 0.3f),
            Color.White.copy(alpha = 0.3f),
            Color.White.copy(alpha = 0.5f),
            Color.White.copy(alpha = 0.0f),
            Color.White.copy(alpha = 0.5f),
            Color.White.copy(alpha = 0.3f)
        )

        val transition = rememberInfiniteTransition(label = "")
        val translateAnimation = transition.animateFloat(
            initialValue = 0f,
            targetValue = (animationDuration+widthOfBrush),
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = animationDuration, easing = LinearEasing), repeatMode = RepeatMode.Reverse
            ), label = ""
        )
        this.background(brush = Brush.linearGradient(colors = shimmerColor,
            start = Offset(x=translateAnimation.value - widthOfBrush,y=0f),
            end = Offset(translateAnimation.value,angleofAxisY)
        ))


    }}
