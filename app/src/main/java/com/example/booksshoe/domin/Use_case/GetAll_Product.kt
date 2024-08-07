package com.example.booksshoe.domin.Use_case

import com.example.booksshoe.data.ProductItem
import retrofit2.HttpException
import retrofit2.Response


sealed class ResultApi<out T>{
    data class Success<T>(val data:T):ResultApi<T>()
    data class Error<T>(val code:Int,val message:String):ResultApi<T>()
    object Loading:ResultApi<Nothing>()
    class Exception<T>(val e:Throwable):ResultApi<T>()
}
suspend fun  <T:Any>handelApi(
    execute: suspend () -> Response<T>
):ResultApi<T>{

    return try {
    val response = execute()
    val body = response.body()
    if (response.isSuccessful && body!=null){
        return ResultApi.Success(body)
    }else{
        return ResultApi.Error(code = response.code(),message = response.message())

    }}
        catch (e: HttpException){
            return ResultApi.Error(code = e.code(),message = e.message())

        }catch (e:Throwable){
            return ResultApi.Exception(e)

        }


}
