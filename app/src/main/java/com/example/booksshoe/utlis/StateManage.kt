package com.example.booksshoe.utlis

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.booksshoe.data.DaoProduct
import com.example.booksshoe.data.ProductItem
import com.example.booksshoe.data.ProductItemX
import com.example.booksshoe.data.products
import com.example.booksshoe.utlis.HttpRout.BASE_URL
import com.example.booksshoe.utlis.HttpRout.PRODUCT
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toCollection
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.internal.wait
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

sealed class StateManage<out T>() {
    object Loading : StateManage<Nothing>()
    class Success<T>(val data : T) : StateManage<T>()
    class Error<T>(val error: Throwable) : StateManage<T>()

}


interface ApiService {
    @GET(PRODUCT)
    suspend fun getProducts():Response<List<ProductItem>>
}
val retrofit=Retrofit.Builder().baseUrl("https://fakestoreapi.com/").addConverterFactory(GsonConverterFactory.create()).build()
val api= retrofit.create(ApiService::class.java)

sealed class  Resource<out T>(val data: T? = null,val  message: String? = null) {
    object Loading : Resource<Nothing>()
    class Success<T>( data : T) : Resource<T>(data= data)
    class Error<T>(val e:kotlin.Exception) : Resource<T>(message = Exception().message)
    class Exception<T>(val error: Throwable) : Resource<T>(message = error.printStackTrace().toString())
}


suspend fun < T:Any>handleApi(execute: suspend () -> Response<T>): Flow<Resource<T>> {
   return flow {
       //emit(Resource.Loading)
       try {
           val response = execute()
           if (response.isSuccessful) {
               response.body()?.let {
                   emit(Resource.Success(it))
                   Log.d("TAG", "handleApi:  success${it}")
               }
           } else {
               emit(Resource.Error(Exception(response.message())))
               Log.d("TAG", "handleApi:  Error${response.message()}")


           }}catch (e:Exception){
               emit(Resource.Exception(e))
           Log.d("TAG", "handleApi:  Exception${e}")

       }
   }


}


suspend fun getProducts(): Flow<Resource<List<ProductItem>>> {



    return handleApi { api.getProducts() }.distinctUntilChanged ()

}




suspend fun Redit() {

        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://the-sneaker-database.p.rapidapi.com/sneakers")
            .get()
            .addHeader("x-rapidapi-key", "5ce348212cmshc1a96261eba25dbp1f133ejsnbe7d135bc991")
            .addHeader("x-rapidapi-host", "the-sneaker-database.p.rapidapi.com")
            .build()

        val respons = client.newCall(request).execute()
        val body = respons.body?.string()
        Log.d("TAG", "getProducts: $body")


    }



class CacheInterceptor():Interceptor{
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        val response = chain.proceed(chain.request())

        return TODO("Provide the return value")
    }
}
