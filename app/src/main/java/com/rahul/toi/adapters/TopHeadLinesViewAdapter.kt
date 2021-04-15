package com.rahul.toi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rahul.toi.R
import com.rahul.toi.clickListeners.NewsClickListener
import com.rahul.toi.model.ArticlesSportsClass
import com.rahul.toi.model.ArticlesTopHealines
import com.rahul.toi.viewHolders.SportsViewHolder
import com.rahul.toi.viewHolders.TopHeadLineViewHolder

class TopHeadLinesViewAdapter(
    private var articlesTopHealines: List<ArticlesTopHealines>,
    private val newsClickListener: NewsClickListener
) :
    RecyclerView.Adapter<TopHeadLineViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopHeadLineViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_horizontal, parent, false)
        return TopHeadLineViewHolder(view, newsClickListener)
    }

    override fun onBindViewHolder(holder: TopHeadLineViewHolder, position: Int) {
        val articlesTopHealines = articlesTopHealines[position]
        holder.setDatas(articlesTopHealines)
    }

    override fun getItemCount(): Int {
        return articlesTopHealines.size
    }

}