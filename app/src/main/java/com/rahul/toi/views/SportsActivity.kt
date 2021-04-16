package com.rahul.toi.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahul.toi.R
import com.rahul.toi.adapters.PoliticsViewAdapter
import com.rahul.toi.clickListeners.NewsClickListener
import com.rahul.toi.interfaces.PoliticsApiService
import com.rahul.toi.interfaces.SportsApiService
import com.rahul.toi.model.ArticlesPoliticsClass
import com.rahul.toi.model.ResponsePoliticsClass
import com.rahul.toi.model.ResponseSportsClass
import com.rahul.toi.network.Network
import kotlinx.android.synthetic.main.activity_politics.*
import kotlinx.android.synthetic.main.activity_sports.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SportsActivity : AppCompatActivity(), NewsClickListener {

    var responseSportsClass = ResponseSportsClass()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sports)
        getApi()
    }

    fun getApi() {
        var sportsApiService =
            Network.getInstance().create(SportsApiService::class.java)

        sportsApiService.getNews()
            .enqueue(object : Callback<ResponseSportsClass> {
                override fun onResponse(
                    call: Call<ResponseSportsClass>,
                    response: Response<ResponseSportsClass>
                ) {
                    if (response.body() != null) {
                        responseSportsClass = response.body()!!
                        val adapter = PoliticsViewAdapter(
                            responseSportsClass.articles as List<ArticlesPoliticsClass>,
                            this@SportsActivity
                        )
                        val linearLayoutManager = LinearLayoutManager(applicationContext)
                        SportsRV.layoutManager = linearLayoutManager
                        SportsRV.adapter = adapter
                        SportsPB.visibility = View.GONE
                    }
                }

                override fun onFailure(call: Call<ResponseSportsClass>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
    }

    override fun onClick(poisiton: Int) {
        val intent = Intent(this, NewsDetails::class.java)
        intent.putExtra("url", responseSportsClass.articles?.get(poisiton)!!.url)
        startActivity(intent)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}