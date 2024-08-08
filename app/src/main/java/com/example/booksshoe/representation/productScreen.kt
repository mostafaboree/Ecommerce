package com.example.booksshoe.representation

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AppBarDefaults.ContentPadding
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextAlign.Companion.Right
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import com.example.booksshoe.data.ProductItem
import com.example.booksshoe.data.ProductItemX
import com.example.booksshoe.ui.theme.BooksShoeTheme
import com.example.eCommerce.R

@Composable
fun ItemProduct(product: ProductItemX, onClick: (ProductItem) -> Unit,modifier: Modifier){
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(250.dp)

        .clip(RoundedCornerShape(20.dp))
        .border(1.dp, Color.LightGray, shape = RoundedCornerShape(20.dp))
    )  {
        Column(modifier = Modifier.fillMaxSize()) {
            LoadImageWithCustomization(imageUrl = product.images.first(), modifier = Modifier)

            Text(text = product.title, modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                ,
                style = androidx.compose.ui.text.TextStyle())
        }

    }
}
@Composable
fun LoadImageWithCustomization(imageUrl: String, modifier: Modifier = Modifier) {

    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .transformations(RoundedCornersTransformation(16f))
            .build(),
        onLoading = {


        },
        onSuccess = {

        },
        onError = {

        },
        contentScale = ContentScale.Fit,
        contentDescription = "Image Description",
        
        error = painterResource(id = R.drawable.ic_launcher_foreground),
        modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(.8f).padding(10.dp).clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .ShimmerloadingAnimation()

    )
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ItemProductPreview(){
    BooksShoeTheme(darkTheme = true)  {
    LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 150.dp)) {

    items(10){
    Card(modifier = Modifier
        .background(Color.White)
        .fillMaxWidth()
        .height(350.dp)
        .padding(10.dp)
        .clip(RoundedCornerShape(10.dp))
        //.border(1.dp, Color.LightGray, shape = RoundedCornerShape(10.dp))
    )  {

        Box(modifier = Modifier.fillMaxSize()) {
            Image(painter = painterResource(id = R.drawable.man), contentDescription = "Image Description",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.background(Color.White)
                    .shadow(10.dp, shape = CircleShape)
                .fillMaxWidth(1f).fillMaxHeight(.8f).clip(CircleShape))


            Text(text = "Product Title", modifier = Modifier.align(Alignment.BottomStart)
                .background(Color.White)
                .fillMaxWidth(1f)
                .fillMaxHeight(.2f)
                .clip(RoundedCornerShape(10.dp)).shadow(5.dp, shape = RoundedCornerShape(10.dp))

                ,
                style =(TextStyle(color = Color.Black.copy(alpha = 0.5f), fontSize =14.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)),
                textAlign =TextAlign.Companion.Center
            )
        }

    }

}}}}
fun Modifier.ShimmerloadingAnimation(
    animationDuration: Int = 1000,
    angleofAxisY: Float = 270f,
    widthOfBrush : Float = 300f
): Modifier {
    return composed{
        val shimmerColor = listOf(Color.White.copy(alpha = 0.3f),
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
            end = Offset(translateAnimation.value,angleofAxisY)))


    }}


//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenLoading(modifier: Modifier = Modifier,loading: Boolean = true) {
    LazyVerticalGrid(columns = GridCells.Fixed(2), contentPadding = ContentPadding,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),){
        items(10) {

            LoadingItem(modifier)

        }
}}

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
