package com.rahul.toi.repository

import com.rahul.toi.interfaces.ApiService
import com.rahul.toi.model.ResponseClass
import com.rahul.toi.model.ResponseMainClass
import com.rahul.toi.network.Network
import java.lang.Exception

class Repository {

    private val apiService = Network.getInstance().create(ApiService::class.java)

    private val responseHanlder = ResponseHandler()

//    suspend fun getNews(): Resource<ResponseMainClass> {
//            val result = apiService.getNews()
//            return responseHanlder.handleSuccess(result)
//    }
}