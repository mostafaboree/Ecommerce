package com.example.booksshoe.data

import coil.network.HttpException
import com.example.booksshoe.domin.ProductRepository
import com.example.booksshoe.domin.Use_case.ResultApi
import com.example.booksshoe.domin.Use_case.handelApi
import retrofit2.Response
import javax.inject.Inject

class ProductRepositoryImp @Inject constructor(private val productDao:DaoProduct): ProductRepository {
    override suspend fun getAllProducts(): ResultApi<products> {
      return  handelApi {productDao.getProducts()}
    }

    override suspend fun getProductByName(name: String): List<ProductItem> {
        TODO("Not yet implemented")
    }

    override suspend fun getProductById(id: Int): ProductItem? =
        try {
            productDao.getProductById(id)
        }catch (e:HttpException){
            null
        }catch (e:Throwable){
            null

        }


    override suspend fun insertProduct(product: ProductItem) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteProduct(product: ProductItem) {
        TODO("Not yet implemented")
    }

    override suspend fun updateProduct(product: ProductItem) {
        TODO("Not yet implemented")
    }
}