package com.rahul.toi.fragments.cityFragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahul.toi.R
import com.rahul.toi.adapters.CityAdapter
<<<<<<< HEAD:app/src/main/java/com/rahul/toi/fragments/cityFragment/CityFragment.kt
import com.rahul.toi.adapters.CityFragmentAdapter
import com.rahul.toi.adapters.HomeFragmentAdapter
=======
import com.rahul.toi.clickListeners.NewsClickListener
>>>>>>> 1212d7c790e5bd419fb277a73079658db7921e4c:app/src/main/java/com/rahul/toi/fragments/CityFragment.kt
import com.rahul.toi.interfaces.ApiService
import com.rahul.toi.model.ResponseMainClass
import com.rahul.toi.network.Network
import com.rahul.toi.views.NewsDetails
import kotlinx.android.synthetic.main.fragment_city.*
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CityFragment : Fragment(), NewsClickListener {
    var responseMainClass: List<ResponseMainClass> = arrayListOf()
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
        return inflater.inflate(R.layout.fragment_city, container, false)
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CityFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var apiClient = Network.getInstance().create(ApiService::class.java)

        apiClient.getNews()
            .enqueue(object : Callback<List<ResponseMainClass>> {
                override fun onResponse(
                    call: Call<List<ResponseMainClass>>,
                    response: Response<List<ResponseMainClass>>
                ) {
                    if (response.body() != null) {
                        responseMainClass = response.body()!!
                        val adapter = CityAdapter(responseMainClass, this@CityFragment)
                        val linearLayoutManager = LinearLayoutManager(context)
                        CityRV.layoutManager = linearLayoutManager
                        CityRV.adapter = adapter
                        City_frag_PB.visibility = View.GONE
                    }
                }

                override fun onFailure(call: Call<List<ResponseMainClass>>, t: Throwable) {
                }

            })


//for tabview//requireActivity().supportFragmentManager
        viewPager_of_cityFragment.adapter =
            CityFragmentAdapter(childFragmentManager)
        tabLayout_cityFragment.setupWithViewPager(viewPager_of_cityFragment)




    }

    override fun onClick(poisiton: Int) {
        val intent = Intent(context, NewsDetails::class.java)
        intent.putExtra("url", responseMainClass[poisiton].url)
        startActivity(intent)

    }

}