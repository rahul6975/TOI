package com.rahul.toi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rahul.toi.R
import com.rahul.toi.clickListeners.NewsClickListener
import com.rahul.toi.model.ArticlesPoliticsClass
import com.rahul.toi.model.ArticlesSportsClass
import com.rahul.toi.viewHolders.PoliticsViewHolder
import com.rahul.toi.viewHolders.SportsViewHolder

class PoliticsViewAdapter(
    private var articlesPoliticsClass: List<ArticlesPoliticsClass>,
    private val newsClickListener: NewsClickListener
) :
    RecyclerView.Adapter<PoliticsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoliticsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.city_recycler_view_layout, parent, false)
        return PoliticsViewHolder(view, newsClickListener)
    }

    override fun onBindViewHolder(holder: PoliticsViewHolder, position: Int) {
        val articlesPoliticsClass = articlesPoliticsClass[position]
        holder.setData(articlesPoliticsClass)
    }

    override fun getItemCount(): Int {
        return articlesPoliticsClass.size
    }


}