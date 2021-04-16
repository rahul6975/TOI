package com.rahul.toi.fragments.homeFragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahul.toi.R
import com.rahul.toi.adapters.PoliticsViewAdapter
import com.rahul.toi.adapters.SportsViewAdapter
import com.rahul.toi.clickListeners.NewsClickListener
import com.rahul.toi.interfaces.EntertainmentApiService
import com.rahul.toi.interfaces.SportsApiService
import com.rahul.toi.model.ArticlesPoliticsClass
import com.rahul.toi.model.ArticlesSportsClass
import com.rahul.toi.model.ResponsePoliticsClass
import com.rahul.toi.model.ResponseSportsClass
import com.rahul.toi.network.Network
import com.rahul.toi.views.NewsDetails
import kotlinx.android.synthetic.main.fragment_home_trending_.*
import kotlinx.android.synthetic.main.fragment_my_feed_.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class home_trending_Fragment : Fragment(), NewsClickListener {
    var responsePoliticsClass = ResponsePoliticsClass()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_trending_, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            home_trending_Fragment().apply {
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
        var sportsApiService = Network.getInstance().create(EntertainmentApiService::class.java)

        sportsApiService.getNews()
            .enqueue(object : Callback<ResponsePoliticsClass> {
                override fun onResponse(
                    call: Call<ResponsePoliticsClass>,
                    response: Response<ResponsePoliticsClass>
                ) {
                    if (response.body() != null) {
                        responsePoliticsClass = response.body()!!
                        val adapter = PoliticsViewAdapter(
                            responsePoliticsClass.articles as List<ArticlesPoliticsClass>,
                            this@home_trending_Fragment
                        )
                        val linearLayoutManager = LinearLayoutManager(context)
                        EntertainmentRV.layoutManager = linearLayoutManager
                        EntertainmentRV.adapter = adapter
                        Trending_Frag_PB.visibility = View.GONE
                    }
                }

                override fun onFailure(call: Call<ResponsePoliticsClass>, t: Throwable) {
                }
            })

    }

    override fun onClick(poisiton: Int) {
        val intent = Intent(context, NewsDetails::class.java)
        intent.putExtra("url", responsePoliticsClass.articles?.get(poisiton)!!.url)
        startActivity(intent)
    }
}