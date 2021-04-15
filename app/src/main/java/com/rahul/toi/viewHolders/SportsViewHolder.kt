package com.rahul.toi.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rahul.toi.clickListeners.NewsClickListener
import com.rahul.toi.model.ArticlesSportsClass
import com.rahul.toi.model.ResponseMainClass
import kotlinx.android.synthetic.main.city_recycler_view_layout.view.*

class SportsViewHolder(private val view: View, private val newsClickListener: NewsClickListener) :
    RecyclerView.ViewHolder(view) {

    fun setData(articlesSportsClass: ArticlesSportsClass) {
        view.apply {
            Glide.with(cityImageView).load(articlesSportsClass.urlToImage).into(cityImageView)
            cityTextView.text = articlesSportsClass.title
            cityTextName.text = articlesSportsClass.description

            CardView.setOnClickListener {
                val position: Int = adapterPosition
                newsClickListener.onClick(position)
            }
        }
    }

}