package com.rahul.toi.fragments.cityFragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahul.toi.R
import com.rahul.toi.adapters.PoliticsViewAdapter
import com.rahul.toi.adapters.TopHeadLinesViewAdapter
import com.rahul.toi.clickListeners.NewsClickListener
import com.rahul.toi.interfaces.PoliticsApiService
import com.rahul.toi.interfaces.TopHeadlineApiService
import com.rahul.toi.model.*
import com.rahul.toi.network.Network
import com.rahul.toi.views.NewsDetails
import kotlinx.android.synthetic.main.activity_politics.*
import kotlinx.android.synthetic.main.fragment_city__mumbai_.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class city_Mumbai_Fragment : Fragment(), NewsClickListener {

    private var responseTopHealines = ResponsePoliticsClass()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_city__mumbai_, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            city_Mumbai_Fragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getApi()
    }

    fun getApi() {
        var politicsApiService =
            Network.getInstance().create(PoliticsApiService::class.java)

        politicsApiService.getNews()
            .enqueue(object : Callback<ResponsePoliticsClass> {
                override fun onResponse(
                    call: Call<ResponsePoliticsClass>,
                    response: Response<ResponsePoliticsClass>
                ) {
                    if (response.body() != null) {
                        responseTopHealines = response.body()!!
                        val adapter = PoliticsViewAdapter(
                            responseTopHealines.articles as List<ArticlesPoliticsClass>,
                            this@city_Mumbai_Fragment
                        )
                        val linearLayoutManager = LinearLayoutManager(context)
                        MumbaiRV.layoutManager = linearLayoutManager
                        MumbaiRV.adapter = adapter
                        MumbaiPB.visibility = View.GONE
                    }
                }

                override fun onFailure(call: Call<ResponsePoliticsClass>, t: Throwable) {
                }

            })
    }

    override fun onClick(poisiton: Int) {
        val intent = Intent(context, NewsDetails::class.java)
        intent.putExtra("url", responseTopHealines.articles?.get(poisiton)!!.url)
        startActivity(intent)
    }
}