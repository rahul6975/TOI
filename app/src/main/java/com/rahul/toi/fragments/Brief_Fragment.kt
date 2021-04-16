package com.rahul.toi.fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rahul.toi.R
import com.rahul.toi.adapters.CityAdapter
import com.rahul.toi.adapters.TopHeadLinesViewAdapter
import com.rahul.toi.clickListeners.NewsClickListener
import com.rahul.toi.interfaces.ApiService
import com.rahul.toi.interfaces.TopHeadlineApiService
import com.rahul.toi.model.ArticlesTopHealines
import com.rahul.toi.model.ResponseMainClass
import com.rahul.toi.model.ResponseTopHealines
import com.rahul.toi.network.Network
import com.rahul.toi.views.NewsDetails
import kotlinx.android.synthetic.main.fragment_brief_.*
import kotlinx.android.synthetic.main.fragment_city.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Brief_Fragment : Fragment(), NewsClickListener {
    var responseTopHealines = ResponseTopHealines()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_brief_, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Brief_Fragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getApi()
    }

    fun getApi() {
        var topNewsApiService = Network.getInstance().create(TopHeadlineApiService::class.java)

        topNewsApiService.getNews()
            .enqueue(object : Callback<ResponseTopHealines> {
                override fun onResponse(
                    call: Call<ResponseTopHealines>,
                    response: Response<ResponseTopHealines>
                ) {
                    if (response.body() != null) {
                        responseTopHealines = response.body()!!
                        val adapter = TopHeadLinesViewAdapter(
                            responseTopHealines.articles as List<ArticlesTopHealines>,
                            this@Brief_Fragment
                        )
                        val linearLayoutManager = LinearLayoutManager(context)
                        BriefRV.layoutManager = linearLayoutManager
                        BriefRV.adapter = adapter
                        brief_PB.visibility = View.GONE
                    }
                }

                override fun onFailure(call: Call<ResponseTopHealines>, t: Throwable) {
                }
            })
    }

    override fun onClick(poisiton: Int) {
        val intent = Intent(context, NewsDetails::class.java)
        intent.putExtra("url", responseTopHealines.articles?.get(poisiton)!!.url)
        startActivity(intent)

    }
}