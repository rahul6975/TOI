package com.rahul.toi.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rahul.toi.model.ResponseMainClass
import kotlinx.android.synthetic.main.city_recycler_view_layout.view.*

class CityViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun setData(responseMainClass: ResponseMainClass) {
        view.apply {
            Glide.with(cityImageView).load(responseMainClass.imageUrl).into(cityImageView)
            cityTextView.text = responseMainClass.title
            cityTextName.text = responseMainClass.name
        }
    }
}