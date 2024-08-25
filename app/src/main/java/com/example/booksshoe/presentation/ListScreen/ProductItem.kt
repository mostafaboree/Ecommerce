package com.example.booksshoe.presentation.ListScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import com.example.BookShoe.R
import com.example.booksshoe.data.ProductItem
import com.example.booksshoe.presentation.imagestate

@Composable
fun ItemProduct(product: ProductItem, onClick: (ProductItem) -> Unit, modifier: Modifier) {
    Card(
        modifier = Modifier
            .clickable {
                onClick(product)
            }
            .width(200.dp)

            .clip(RoundedCornerShape(20.dp)),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            LoadImageWithCustomization(imageUrl = product.image, Modifier, imagestate.Loading)

            TextItem(text = product.title)
            TextItem(text = product.price.toString())


        }

    }
}

@Composable
 private fun LoadImageWithCustomization(imageUrl: String, modifier: Modifier,imagestate: imagestate ) {

    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .transformations(RoundedCornersTransformation(16f))
            .build(),
        onLoading = {},
        onSuccess = {},
        onError = {},
        contentScale = ContentScale.Inside,
        contentDescription = "Image Description",
        error = painterResource(id = R.drawable.ic_launcher_foreground),
        modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(.7f)
            .border(1.dp, Color.Gray, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .ShimmerloadingAnimation()

    )
}
@Composable
private fun TextItem(text: String) {
    Text(
        text = text, modifier = Modifier
            .background(Color.White)
            .fillMaxWidth(),
        color = Color.Black, fontSize = 20.sp,
        maxLines = 1,
        fontWeight = FontWeight.Medium, fontFamily = FontFamily.Serif,
        textAlign = TextAlign.Center
    )
}