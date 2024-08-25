package com.example.booksshoe.presentation
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booksshoe.data.ProductItem
import com.example.booksshoe.utlis.StateManage
import com.example.booksshoe.domin.Use_case.ResultApi
import com.example.booksshoe.domin.Use_case.ResultApi.Success
import com.example.booksshoe.domin.Use_case.UseCaseProduct
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ViewModel_Product @Inject constructor(private val useCase: UseCaseProduct):ViewModel () {
 private val product= MutableStateFlow<List<ProductItem>>(emptyList())
    val _product:StateFlow<List<ProductItem>> = product
    
   private var state = MutableStateFlow<StateManage<Any>>(StateManage.Loading)
    val _state: StateFlow<StateManage<Any>> = state

    private var getProductsJob: Job? = null

init {
    viewModelScope.launch {
    getProducts()}
}


    private suspend fun getProducts() {
getProductsJob?.cancel()
        viewModelScope.launch {
          val result=  useCase.getProducts()
            when(result) {
                is Success -> {
                    state.update { it ->
                        StateManage.Success(result.data)

                    }

                }

                is ResultApi.Exception -> {
                  //  state.value = ResultApi.Error(code = result.code, result.message)
                    state.emit(StateManage.Error(result.e))
                }

                is ResultApi.Loading -> {
                   state.emit(StateManage.Loading)
                }

                is ResultApi.Error -> TODO()
            }


        }

    }


}

