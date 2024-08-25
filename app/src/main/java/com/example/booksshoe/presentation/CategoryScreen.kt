package com.example.booksshoe.presentation

import android.util.Log
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.InfiniteTransition
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBarDefaults.ContentPadding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.booksshoe.presentation.ListScreen.CardOffer
import com.example.booksshoe.presentation.ListScreen.ToolBar
import com.example.booksshoe.presentation.ListScreen.TypeProduct
import com.example.BookShoe.R
import com.example.booksshoe.data.ProductItem
import com.example.booksshoe.presentation.ListScreen.ItemProduct
import com.example.booksshoe.presentation.ListScreen.LoadingItem
import com.example.booksshoe.utlis.categoryList


//@Preview(showBackground = true)
@Composable
fun MainScreen(products:List<ProductItem>, isLoading:Boolean,navController: NavController){
    var datastate by remember { mutableStateOf<Any>(StateManag.Loading) }
    if (isLoading) {
        datastate = StateManag.Loading
    } else {
        datastate = StateManag.Success
    }
    Crossfade(targetState = datastate, label = "",
        animationSpec = tween(1000, 500)) { it ->
        when (it) {
            is StateManag.error -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                    Image(
                        painter = painterResource(id = R.drawable.error),
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(100.dp)
                    )
                }
            }

            StateManag.Loading -> {
                MainScreenLoading()
            }

            StateManag.Success -> {
                Log.d("TAG", "onCreate: $datastate")
                MainScreen(products)
            }

        }

    }
    }

@Composable
private fun MainScreen(products: List<ProductItem>) {
    Column(
        modifier = Modifier

            .fillMaxSize()
    ) {
        ToolBar(name = "Mostafa Sayed".uppercase(), massage = "Welcome Back")
        CardOffer()
        TypeProduct(categoryList) {

        }
        LazyRow(
            contentPadding = ContentPadding,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(products) { item ->
                ItemProduct(
                    product = item,
                    onClick = {},
                    modifier = Modifier.background(color = Color.White)
                )

            }
        }

    }
}







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


sealed class imagestate(){
    object Loading : imagestate()
    object Success : imagestate()
    object Error : imagestate()

}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Play(){
    val padding = rememberInfiniteTransition(label = "")


val indexer = rememberInfiniteTransition(label = "")
    var indexa = indexer.animateValue(
        initialValue = 0,
        targetValue = 10,
        typeConverter = Int.VectorConverter ,
        animationSpec = infiniteRepeatable(tween(1000), repeatMode = RepeatMode.Reverse), label = ""
    )

   Box(modifier = Modifier.fillMaxSize(),
       contentAlignment = Alignment.Center) {
LazyRow(modifier = Modifier.fillMaxWidth(), contentPadding = ContentPadding,verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Center) {
    items(5) { index ->
        Re(index+1,indexa.value)
   }}}

}

@Composable
private fun Anim(
    indexa:Int
): State<Float> {
    val padding = rememberInfiniteTransition(label = "")

    val x = padding.animateFloat(
        initialValue = 5f, targetValue = indexa.toFloat()*40,
        animationSpec = InfiniteRepeatableSpec(
            animation = tween(1000,1,
                FastOutLinearInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = ""
    )
    return x
}

@Composable
private fun Re( index: Int,indexa:Int) {
    val anim = Anim( indexa =index)
    Canvas(
        modifier = Modifier
            .width(10.dp)
            .height(50.dp)
            .padding(horizontal = 2.dp, vertical = anim.value.dp)
    ) {
        drawRect(
            brush = Brush.linearGradient(colors = listOf(Color.Red, Color.Blue))
        )


    }
}