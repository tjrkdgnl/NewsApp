package com.hugh.top_news.presentation.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.hugh.entity.ArticleEntity

class TopNewsAdapter(
    private val moveToDetailCallback: (ArticleEntity) -> Unit
) : PagingDataAdapter<ArticleEntity, TopNewsViewHolder>(
    object : DiffUtil.ItemCallback<ArticleEntity>() {
        override fun areItemsTheSame(oldItem: ArticleEntity, newItem: ArticleEntity): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: ArticleEntity, newItem: ArticleEntity): Boolean {
            return oldItem == newItem
        }
    }
) {
    override fun onBindViewHolder(holder: TopNewsViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopNewsViewHolder {
        return TopNewsViewHolder(parent, moveToDetailCallback)
    }
}