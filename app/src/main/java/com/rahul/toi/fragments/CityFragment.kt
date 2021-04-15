package com.rahul.toi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahul.toi.R
import com.rahul.toi.adapters.CityAdapter
import com.rahul.toi.interfaces.ApiService
import com.rahul.toi.model.ResponseMainClass
import com.rahul.toi.network.Network
import kotlinx.android.synthetic.main.fragment_city.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CityFragment : Fragment() {
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
                        val adapter = CityAdapter(responseMainClass)
                        val linearLayoutManager = LinearLayoutManager(context)
                        CityRV.layoutManager = linearLayoutManager
                        CityRV.adapter = adapter
                    }
                }
                override fun onFailure(call: Call<List<ResponseMainClass>>, t: Throwable) {
                }

            })
    }

}