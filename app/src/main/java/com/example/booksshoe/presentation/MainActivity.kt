package com.example.booksshoe.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf

import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.booksshoe.ui.theme.BooksShoeTheme
import com.example.booksshoe.utlis.Resource
import com.example.booksshoe.utlis.getProducts
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import com.example.BookShoe.R
import com.example.booksshoe.data.ProductItem


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
                var list by remember { mutableStateOf(emptyList<ProductItem>()) }
                var isLoading by remember { mutableStateOf(true) }

                LocalContext.current
                scope.launch  {



                    getProducts().distinctUntilChanged().collect {
                        state ->
                        when (state) {
                            is Resource.Error -> {
                                isLoading = false
                                datastate = StateManag.error
                                Log.d("TAG", "onCreate: error is ${state.e.message}")
                            }

                            is Resource.Loading -> {
                                isLoading = true
                                Log.d("TAG", "onCreate: $isLoading")
                                datastate = StateManag.Loading

                            }

                            is Resource.Success -> {
                                list = state.data as List<ProductItem>
                                isLoading = false
                                datastate = StateManag.Success
                                Log.d("TAG", "onCreate: $list")

                            }
                            is Resource.Exception->{
                                isLoading = false
                                datastate = StateManag.error
                                Log.d("TAG", "onCreate: error ex is ${state.error.printStackTrace()}")

                            } } }
                }
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination ="splash" ){
                    composable("splash"){ StartScreen(navController = navController){
                        navController.navigate("main")

                    }}
                    composable("main"){
                        MainScreen(list,isLoading,navController)
                        navController.currentBackStackEntry
                    }


                }}}}}
sealed class  StateManag<out T>{
    object Loading:StateManag<Nothing>()
    object Success:StateManag<Nothing>()
    object error:StateManag<Nothing>()

}








