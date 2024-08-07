package com.example.booksshoe.data

import kotlinx.serialization.Serializable


@Serializable
 data class ProductItem(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
){


}
