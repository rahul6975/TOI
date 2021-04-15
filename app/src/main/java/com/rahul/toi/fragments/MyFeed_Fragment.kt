package com.rahul.toi.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahul.toi.R
import com.rahul.toi.adapters.CityAdapter
import com.rahul.toi.adapters.SportsViewAdapter
import com.rahul.toi.clickListeners.NewsClickListener
import com.rahul.toi.interfaces.ApiService
import com.rahul.toi.interfaces.SportsApiService
import com.rahul.toi.model.ArticlesSportsClass
import com.rahul.toi.model.ResponseMainClass
import com.rahul.toi.model.ResponseSportsClass
import com.rahul.toi.network.Network
import com.rahul.toi.views.NewsDetails
import kotlinx.android.synthetic.main.fragment_brief_.*
import kotlinx.android.synthetic.main.fragment_city.*
import kotlinx.android.synthetic.main.fragment_my_feed_.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MyFeed_Fragment : Fragment(), NewsClickListener {

    var responseSportsClass = ResponseSportsClass()


    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_feed_, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyFeed_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getApi()
    }

    fun getApi() {
        var sportsApiService = Network.getInstance().create(SportsApiService::class.java)

        sportsApiService.getNews()
            .enqueue(object : Callback<ResponseSportsClass> {
                override fun onResponse(
                    call: Call<ResponseSportsClass>,
                    response: Response<ResponseSportsClass>
                ) {
                    if (response.body() != null) {
                        responseSportsClass = response.body()!!
                        val adapter =
                            SportsViewAdapter(
                                responseSportsClass.articles as List<ArticlesSportsClass>,
                                this@MyFeed_Fragment
                            )
                        val linearLayoutManager = LinearLayoutManager(context)
                        FEED_RV.layoutManager = linearLayoutManager
                        FEED_RV.adapter = adapter
                    }
                }

                override fun onFailure(call: Call<ResponseSportsClass>, t: Throwable) {
                }

            })
    }

    override fun onClick(poisiton: Int) {
        val intent = Intent(context, NewsDetails::class.java)
        intent.putExtra("url", responseSportsClass.articles?.get(poisiton)!!.url)
        startActivity(intent)

    }


}