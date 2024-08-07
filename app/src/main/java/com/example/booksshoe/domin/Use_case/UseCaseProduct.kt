package com.example.booksshoe.domin.Use_case

import com.example.booksshoe.data.ProductRepositoryImp
import com.example.booksshoe.domin.ProductRepository
import javax.inject.Inject

class UseCaseProduct@Inject constructor(private val repository: ProductRepository) {
    suspend fun getProducts() = repository.getAllProducts()
    suspend fun getProduct(id: Int) = repository.getProductById(id)




}
