package com.rahul.toi.interfaces

import com.rahul.toi.model.ResponseClass
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiSearch {

     @GET("top-headlines")
     fun getNewsSearch(@Query("country") country:String):ResponseClass

    @GET("everything")
    fun getNewsSearch2(@Query("q") q:String ):ResponseClass
}