package com.ozimos.androidpaginationapps

import retrofit2.Call
import retrofit2.http.GET

interface UserService {
    @GET("users")
    fun getAllUser() : Call<List<DataItem>>
}