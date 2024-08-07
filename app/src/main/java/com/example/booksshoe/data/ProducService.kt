package com.example.booksshoe.data

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logging
import kotlinx.serialization.json.Json

interface ProducService {
   suspend fun getProducts(): List<ProductItem>
   suspend fun getProduct(id: Int): ProductItem?


   companion object {
       fun create(): ProducService? {

           HttpClient(Android) {
               install(Logging) {
                   level = LogLevel.ALL
               }
               install(JsonFeature) {
                   serializer = KotlinxSerializer()
               }
           }
           return null
       }
   }}




