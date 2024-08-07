package com.example.booksshoe.di

import com.example.booksshoe.data.DaoProduct
import com.example.booksshoe.data.ProductRepositoryImp
import com.example.booksshoe.utlis.HttpRout.BASE_URL
import com.example.booksshoe.domin.ProductRepository
import com.example.booksshoe.domin.Use_case.UseCaseProduct
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {



    @Provides
    @Singleton
    fun provideHttpclient(): OkHttpClient {
        val builder=OkHttpClient.Builder()
        return builder.build()

    }



    @Provides
    @Singleton
    fun provideRetrofit(httpClient: OkHttpClient):Retrofit{
        val retrofit=Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(httpClient).build()
        return retrofit
    }


    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit):DaoProduct{
       return retrofit.create(DaoProduct::class.java)
    }


    @Provides
    @Singleton
    fun provideRepository(productRepository: ProductRepository):UseCaseProduct{
        return UseCaseProduct(productRepository)

    }



}