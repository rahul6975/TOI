package com.rahul.toi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rahul.toi.R
import com.rahul.toi.clickListeners.NewsClickListener
import com.rahul.toi.model.ResponseMainClass
import com.rahul.toi.viewHolders.CityViewHolder

class CityAdapter(
    private var responseMainClass: List<ResponseMainClass>,
    private val newsClickListener: NewsClickListener
) :
    RecyclerView.Adapter<CityViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.city_recycler_view_layout, parent, false)
        return CityViewHolder(view, newsClickListener)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val responseMainClass = responseMainClass[position]
        holder.setData(responseMainClass)
    }

    override fun getItemCount(): Int {
        return responseMainClass.size
    }

    fun updateData(responseMainClass: List<ResponseMainClass>) {
        this.responseMainClass = responseMainClass
        notifyDataSetChanged()
    }
}