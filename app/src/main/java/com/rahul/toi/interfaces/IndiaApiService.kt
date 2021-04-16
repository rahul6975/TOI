package com.rahul.toi.interfaces

import com.rahul.toi.model.ResponsePoliticsClass
import retrofit2.Call
import retrofit2.http.GET

interface IndiaApiService {

    @GET("india")
    fun getNews(): Call<ResponsePoliticsClass>
}