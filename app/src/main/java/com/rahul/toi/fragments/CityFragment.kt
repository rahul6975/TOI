package com.rahul.toi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahul.toi.R
import com.rahul.toi.adapters.CityAdapter
import com.rahul.toi.interfaces.ApiService
import com.rahul.toi.model.ResponseMainClass
import com.rahul.toi.network.Network
import com.rahul.toi.viewModels.ViewModel
import kotlinx.android.synthetic.main.fragment_city.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CityFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CityFragment : Fragment() {
    var responseMainClass: List<ResponseMainClass> = arrayListOf()
//    var adapter = CityAdapter(responseMainClass)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_city, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CityFragment.
         */
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