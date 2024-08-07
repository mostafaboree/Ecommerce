package com.example.booksshoe.domin

import com.example.booksshoe.data.ProductItem
import com.example.booksshoe.data.products
import com.example.booksshoe.domin.Use_case.ResultApi

interface ProductRepository {
    suspend fun getAllProducts():ResultApi<products>
    suspend fun getProductByName(name: String): List<ProductItem>
    suspend fun getProductById(id: Int): ProductItem?
    suspend fun insertProduct(product: ProductItem)
    suspend fun deleteProduct(product: ProductItem)
    suspend fun updateProduct(product: ProductItem)


}