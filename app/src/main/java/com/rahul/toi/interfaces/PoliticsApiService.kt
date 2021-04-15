package com.rahul.toi.interfaces

import com.rahul.toi.model.ResponsePoliticsClass
import com.rahul.toi.model.ResponseSportsClass
import retrofit2.Call
import retrofit2.http.GET

interface PoliticsApiService {

    @GET("politics")
    fun getNews(): Call<ResponsePoliticsClass>
}