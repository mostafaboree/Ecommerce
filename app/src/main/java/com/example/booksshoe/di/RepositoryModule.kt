package com.example.booksshoe.di

import com.example.booksshoe.data.ProductRepositoryImp
import com.example.booksshoe.domin.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
 abstract class RepositoryModule {
     @Binds
     abstract fun bindRepository(repositoryImpl: ProductRepositoryImp): ProductRepository

}