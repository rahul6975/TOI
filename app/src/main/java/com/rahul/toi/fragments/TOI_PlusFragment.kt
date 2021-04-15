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
import com.rahul.toi.adapters.PoliticsViewAdapter
import com.rahul.toi.adapters.SportsViewAdapter
import com.rahul.toi.clickListeners.NewsClickListener
import com.rahul.toi.interfaces.ApiService
import com.rahul.toi.interfaces.PoliticsApiService
import com.rahul.toi.interfaces.SportsApiService
import com.rahul.toi.model.*
import com.rahul.toi.network.Network
import com.rahul.toi.views.NewsDetails
import kotlinx.android.synthetic.main.fragment_brief_.*
import kotlinx.android.synthetic.main.fragment_my_feed_.*
import kotlinx.android.synthetic.main.fragment_t_o_i__plus.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class TOI_PlusFragment : Fragment(), NewsClickListener {

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
        return inflater.inflate(R.layout.fragment_t_o_i__plus, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TOI_PlusFragment().apply {
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
        var politicsApiService = Network.getInstance().create(PoliticsApiService::class.java)

        politicsApiService.getNews()
            .enqueue(object : Callback<ResponsePoliticsClass> {
                override fun onResponse(
                    call: Call<ResponsePoliticsClass>,
                    response: Response<ResponsePoliticsClass>
                ) {
                    responsePoliticsClass = response.body()!!
                    val adapter =
                        PoliticsViewAdapter(
                            responsePoliticsClass.articles as List<ArticlesPoliticsClass>,
                            this@TOI_PlusFragment
                        )
                    val linearLayoutManager = LinearLayoutManager(context)
                    TOI_PLUS_RV.layoutManager = linearLayoutManager
                    TOI_PLUS_RV.adapter = adapter

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


