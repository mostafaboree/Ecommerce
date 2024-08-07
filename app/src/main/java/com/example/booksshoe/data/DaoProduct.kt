package com.example.booksshoe.data

import com.example.booksshoe.utlis.HttpRout.PRODUCT
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface DaoProduct {
    @GET(PRODUCT)
    suspend fun getProducts(): Response<products>

    @GET("$PRODUCT/{id}")
   suspend fun getProductById(id: Int): ProductItem
}

