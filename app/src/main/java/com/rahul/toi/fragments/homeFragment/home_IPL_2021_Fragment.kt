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
import com.rahul.toi.interfaces.SportsApiService
import com.rahul.toi.model.ArticlesSportsClass
import com.rahul.toi.model.ResponseSportsClass
import com.rahul.toi.network.Network
import com.rahul.toi.views.NewsDetails
import kotlinx.android.synthetic.main.fragment_home__gadgets_now_.*
import kotlinx.android.synthetic.main.fragment_home__i_p_l_2021_.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class home_IPL_2021_Fragment : Fragment(), NewsClickListener {

    var responseSportsClass = ResponseSportsClass()

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
        return inflater.inflate(R.layout.fragment_home__i_p_l_2021_, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            home_IPL_2021_Fragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getApi()
    }

    fun getApi() {
        var SportsApiService = Network.getInstance().create(SportsApiService::class.java)

        SportsApiService.getNews()
            .enqueue(object : Callback<ResponseSportsClass> {
                override fun onResponse(
                    call: Call<ResponseSportsClass>,
                    response: Response<ResponseSportsClass>
                ) {
                    if (response.body() != null) {
                        responseSportsClass = response.body()!!
                        val adapter = SportsViewAdapter(
                            responseSportsClass.articles as List<ArticlesSportsClass>,
                            this@home_IPL_2021_Fragment
                        )
                        val linearLayoutManager = LinearLayoutManager(context)
                        IPLRV.layoutManager = linearLayoutManager
                        IPLRV.adapter = adapter
                        IPLPB.visibility = View.GONE
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