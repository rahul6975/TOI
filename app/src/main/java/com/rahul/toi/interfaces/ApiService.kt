package com.rahul.toi.interfaces

import com.rahul.toi.model.ResponseClass
import com.rahul.toi.model.ResponseMainClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/")
    fun getNews(): Call<List<ResponseMainClass>>
}