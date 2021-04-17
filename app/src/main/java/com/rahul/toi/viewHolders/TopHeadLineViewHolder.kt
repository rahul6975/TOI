package com.rahul.toi.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rahul.toi.clickListeners.NewsClickListener
import com.rahul.toi.model.ArticlesSportsClass
import com.rahul.toi.model.ArticlesTopHealines
import kotlinx.android.synthetic.main.city_recycler_view_layout.view.*
import kotlinx.android.synthetic.main.recycler_view_horizontal.view.*

class TopHeadLineViewHolder(
    private val view: View,
    private val newsClickListener: NewsClickListener
) :
    RecyclerView.ViewHolder(view) {

    fun setDatas(articlesTopHealines: ArticlesTopHealines) {
        view.apply {
            Glide.with(imageView).load(articlesTopHealines.urlToImage).into(imageView)
            tvDescription.text = articlesTopHealines.description
            BriefCardView.setOnClickListener {
                val position: Int = adapterPosition
                newsClickListener.onClick(position)
            }
        }
    }

}