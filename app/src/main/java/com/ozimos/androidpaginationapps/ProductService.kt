package com.ozimos.androidpaginationapps

import retrofit2.Call
import retrofit2.http.GET

interface ProductService {
    @GET("products")
    fun getAllProducts() : Call<List<ProductModel>>
}