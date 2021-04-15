package com.rahul.toi.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.rahul.toi.model.ResponseClass
import com.rahul.toi.model.ResponseMainClass
import com.rahul.toi.repository.Repository
import com.rahul.toi.repository.Resource
import kotlinx.coroutines.Dispatchers

class ViewModel : ViewModel() {

    private val myRepository = Repository()

//    fun getNews(): LiveData<ResponseMainClass> {
//        return liveData(Dispatchers.IO) {
//            val result = myRepository.getNews()
//            emit(result.data!!)
//        }
//    }
}