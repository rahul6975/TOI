package com.rahul.toi.interfaces

import com.rahul.toi.model.ResponseMainClass
import com.rahul.toi.model.ResponseSportsClass
import retrofit2.Call
import retrofit2.http.GET

interface SportsApiService {

    @GET("sports")
    fun getNews(): Call<ResponseSportsClass>
}