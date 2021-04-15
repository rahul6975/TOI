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

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Brief_Fragment : Fragment(), NewsClickListener {
    var responseTopHealines = ResponseTopHealines()
    var isScrolling: Boolean = false
    var currentItem: Int = 0
    var totalItems: Int = 0
    var scrollItems: Int = 0

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_brief_, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Brief_Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Brief_Fragment().apply {
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