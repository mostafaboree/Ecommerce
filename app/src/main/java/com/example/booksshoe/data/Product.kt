package com.example.booksshoe.data

import kotlinx.serialization.Serializable
typealias products=List<ProductItem>
@Serializable
class Product : ArrayList<ProductItem>()