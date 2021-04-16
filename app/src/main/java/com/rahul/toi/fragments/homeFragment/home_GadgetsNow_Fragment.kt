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
import com.rahul.toi.clickListeners.NewsClickListener
import com.rahul.toi.interfaces.EntertainmentApiService
import com.rahul.toi.interfaces.TechnologyApiService
import com.rahul.toi.model.ArticlesPoliticsClass
import com.rahul.toi.model.ResponsePoliticsClass
import com.rahul.toi.network.Network
import com.rahul.toi.views.NewsDetails
import kotlinx.android.synthetic.main.fragment_home__gadgets_now_.*
import kotlinx.android.synthetic.main.fragment_home_trending_.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class home_GadgetsNow_Fragment : Fragment(), NewsClickListener {

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
        return inflater.inflate(R.layout.fragment_home__gadgets_now_, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            home_GadgetsNow_Fragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getApi()
    }

    fun getApi() {
        var technologyApiService = Network.getInstance().create(TechnologyApiService::class.java)

        technologyApiService.getNews()
            .enqueue(object : Callback<ResponsePoliticsClass> {
                override fun onResponse(
                    call: Call<ResponsePoliticsClass>,
                    response: Response<ResponsePoliticsClass>
                ) {
                    if (response.body() != null) {
                        responsePoliticsClass = response.body()!!
                        val adapter = PoliticsViewAdapter(
                            responsePoliticsClass.articles as List<ArticlesPoliticsClass>,
                            this@home_GadgetsNow_Fragment
                        )
                        val linearLayoutManager = LinearLayoutManager(context)
                        TechRV.layoutManager = linearLayoutManager
                        TechRV.adapter = adapter
                        TechPB.visibility = View.GONE
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