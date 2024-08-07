package com.example.booksshoe.representation

import android.annotation.SuppressLint
import android.graphics.drawable.PaintDrawable
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.AppBarDefaults.ContentPadding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.mutableStateOf

import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.booksshoe.R

import com.example.booksshoe.data.ProductItem
import com.example.booksshoe.data.ProductItemX
import com.example.booksshoe.data.products
import com.example.booksshoe.utlis.StateManage
import com.example.booksshoe.ui.theme.BooksShoeTheme
import com.example.booksshoe.utlis.Redit
import com.example.booksshoe.utlis.Resource
import com.example.booksshoe.utlis.getProducts
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @SuppressLint("CoroutineCreationDuringComposition", "UnusedCrossfadeTargetStateParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var datastate by remember { mutableStateOf<Any>(StateManag.Loading) }

            BooksShoeTheme {
                val viewModel = hiltViewModel<ViewModel_Product>()
                val state = viewModel._state
                val scope = rememberCoroutineScope()
                var list by remember { mutableStateOf(emptyList<ProductItemX>()) }
                var isLoading by remember { mutableStateOf(true) }
              //  MainScreenLoading( Modifier,isLoading)
scope.launch(Dispatchers.IO) {
    Redit()

}


                val context = LocalContext.current
                scope.launch  {
                    /* state.collect{ state->
                    when(state){
                        is StateManage.Error -> {
                            isLoading = false
                            error = state.error.message.toString()

                        }
                        StateManage.Loading -> {
                            isLoading = true

                        }
                        is StateManage.Success -> {
                           list = state.data as List<ProductItem>
                            isLoading = false
                        }
                    }}}
                list.let {
                    if (isLoading){
                        Box(modifier = Modifier.fillMaxSize()){
                            CircularProgressIndicator(modifier = Modifier.align(androidx.compose.ui.Alignment.Center))
                        }
                    }else{
                        MainScreen(products = it)
                    }
                }
               }*/


                    getProducts().distinctUntilChanged().collect {
                        state ->
                        when (state) {
                            is Resource.Error -> {
                                isLoading = false
                                datastate = StateManag.error
                                Log.d("TAG", "onCreate: ${state.e}")
                            }

                            is Resource.Loading -> {
                                isLoading = true
                                Log.d("TAG", "onCreate: $isLoading")
                                datastate = StateManag.Loading

                            }

                            is Resource.Success -> {
                                list = state.data as List<ProductItemX>
                                isLoading = false
                                datastate = StateManag.Success
                                Log.d("TAG", "onCreate: $list")

                            }
                            is Resource.Exception->{
                                isLoading = false
                                datastate = StateManag.error
                                Log.d("TAG", "onCreate: ${state.message}")

                            } } }
                }


Crossfade(targetState = datastate, label = "",
    animationSpec = tween(3000, 500)) { it ->
                when (it) {
                    is StateManag.error -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = androidx.compose.ui.Alignment.Center
                        ) {
                            CircularProgressIndicator(modifier = Modifier.align(androidx.compose.ui.Alignment.Center))
                            Image(
                                painter = painterResource(id = R.drawable.error),
                                contentDescription = null,
                                modifier = Modifier
                                    .align(androidx.compose.ui.Alignment.Center)
                                    .size(100.dp)
                            )
                        }
                    }

                    StateManag.Loading -> {
                       MainScreenLoading()


                    }

                    StateManag.Success -> {
                        Log.d("TAG", "onCreate: $datastate")
                        MainScreen(products = list )
                    }

                }



    }}}}


}

@Preview(showBackground = true)
@SuppressLint("CoroutineCreationDuringComposition", "SuspiciousIndentation")
@Composable
fun MainScreen(products:List<ProductItemX>,isLoading:Boolean =true){
       LazyVerticalGrid(columns =GridCells.Fixed(2), modifier = Modifier.fillMaxSize(),
           contentPadding = ContentPadding
       , horizontalArrangement = Arrangement.spacedBy(10.dp),
           verticalArrangement = Arrangement.spacedBy(10.dp)){
           items(products){item->
               ItemProduct(product = item, onClick ={} , modifier =Modifier.background(color = Color.White) )

           }

       }





}

 sealed class  StateManag<out T>{
     object Loading:StateManag<Nothing>()
     object Success:StateManag<Nothing>()
     object error:StateManag<Nothing>()

 }