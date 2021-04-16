package com.rahul.toi.interfaces

import com.rahul.toi.model.ResponseSportsClass
import com.rahul.toi.model.ResponseTopHealines
import retrofit2.Call
import retrofit2.http.GET

interface TopHeadlineApiService {
    @GET("topHeadlines")
    fun getNews(): Call<ResponseTopHealines>
}