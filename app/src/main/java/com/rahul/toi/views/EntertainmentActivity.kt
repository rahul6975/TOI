package com.rahul.toi.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahul.toi.R
import com.rahul.toi.adapters.PoliticsViewAdapter
import com.rahul.toi.clickListeners.NewsClickListener
import com.rahul.toi.interfaces.EntertainmentApiService
import com.rahul.toi.interfaces.TechnologyApiService
import com.rahul.toi.model.ArticlesPoliticsClass
import com.rahul.toi.model.ResponsePoliticsClass
import com.rahul.toi.network.Network
import kotlinx.android.synthetic.main.activity_entertainment.*
import kotlinx.android.synthetic.main.activity_gadgets.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EntertainmentActivity : AppCompatActivity(), NewsClickListener {

    var responsePoliticsClass = ResponsePoliticsClass()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entertainment)
        getApi()
    }

    fun getApi() {
        var entertainmentApiService =
            Network.getInstance().create(EntertainmentApiService::class.java)

        entertainmentApiService.getNews()
            .enqueue(object : Callback<ResponsePoliticsClass> {
                override fun onResponse(
                    call: Call<ResponsePoliticsClass>,
                    response: Response<ResponsePoliticsClass>
                ) {
                    if (response.body() != null) {
                        responsePoliticsClass = response.body()!!
                        val adapter = PoliticsViewAdapter(
                            responsePoliticsClass.articles as List<ArticlesPoliticsClass>,
                            this@EntertainmentActivity
                        )
                        val linearLayoutManager = LinearLayoutManager(applicationContext)
                        EnterRV.layoutManager = linearLayoutManager
                        EnterRV.adapter = adapter
                        EnterPB.visibility = View.GONE



                    }
                }

                override fun onFailure(call: Call<ResponsePoliticsClass>, t: Throwable) {
                }
            })
    }

    override fun onClick(poisiton: Int) {
        val intent = Intent(this, NewsDetails::class.java)
        intent.putExtra("url", responsePoliticsClass.articles?.get(poisiton)!!.url)
        startActivity(intent)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}