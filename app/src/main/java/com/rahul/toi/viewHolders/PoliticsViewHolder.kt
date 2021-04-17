package com.rahul.toi.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rahul.toi.clickListeners.NewsClickListener
import com.rahul.toi.model.ArticlesPoliticsClass
import com.rahul.toi.model.ArticlesSportsClass
import kotlinx.android.synthetic.main.city_recycler_view_layout.view.*

class PoliticsViewHolder(private val view: View, private val newsClickListener: NewsClickListener) :
    RecyclerView.ViewHolder(view) {

    fun setData(articlesPoliticsClass: ArticlesPoliticsClass) {
        view.apply {
            Glide.with(cityImageView).load(articlesPoliticsClass.urlToImage).into(cityImageView)
            cityTextView.text = articlesPoliticsClass.title
            cityTextName.text = "Times Of India"

            CardView.setOnClickListener {
                val position: Int = adapterPosition
                newsClickListener.onClick(position)
            }
        }
    }

}