package com.rahul.toi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rahul.toi.R
import com.rahul.toi.clickListeners.NewsClickListener
import com.rahul.toi.model.ArticlesSportsClass
import com.rahul.toi.model.ResponseMainClass
import com.rahul.toi.viewHolders.CityViewHolder
import com.rahul.toi.viewHolders.SportsViewHolder


class SportsViewAdapter(
    private var articlesSportsClass: List<ArticlesSportsClass>,
    private val newsClickListener: NewsClickListener
) :
    RecyclerView.Adapter<SportsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.city_recycler_view_layout, parent, false)
        return SportsViewHolder(view, newsClickListener)
    }

    override fun onBindViewHolder(holder: SportsViewHolder, position: Int) {
        val articlesSportsClass = articlesSportsClass[position]
        holder.setData(articlesSportsClass)
    }

    override fun getItemCount(): Int {
        return articlesSportsClass.size
    }

}