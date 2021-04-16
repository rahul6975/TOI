package com.rahul.toi.interfaces

import com.rahul.toi.model.ResponsePoliticsClass
import retrofit2.Call
import retrofit2.http.GET

interface BusinessApiService {
    @GET("business")
    fun getNews(): Call<ResponsePoliticsClass>
}