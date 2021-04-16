package com.rahul.toi.interfaces

import com.rahul.toi.model.ResponseMainClass
import com.rahul.toi.model.ResponsePoliticsClass
import retrofit2.Call
import retrofit2.http.GET

interface EntertainmentApiService {
    @GET("entertainment")
    fun getNews(): Call<ResponsePoliticsClass>
}