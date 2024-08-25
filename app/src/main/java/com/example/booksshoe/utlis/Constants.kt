package com.example.booksshoe.utlis

import com.example.BookShoe.R
import com.example.booksshoe.data.Category

object HttpRout{
     const val BASE_URL="https://fakestoreapi.com/"
    const val PRODUCT="products"
}
 val categoryList= listOf(
    Category(1, R.drawable.electronic,"Electronic"),
    Category(2, R.drawable.man,"Fashion"),
    Category(3, R.drawable.jewelly,"Jewelly"),
    Category(4, R.drawable.zare,"Kids"))