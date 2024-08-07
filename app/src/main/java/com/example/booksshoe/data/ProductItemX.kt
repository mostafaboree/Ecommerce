package com.example.booksshoe.data

data class ProductItemX(
    val category: Category,
    val description: String,
    val id: Int,
    val images: List<String>,
    val price: Int,
    val title: String
)