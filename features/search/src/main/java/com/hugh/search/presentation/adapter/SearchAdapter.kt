package com.hugh.search.presentation.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.hugh.entity.ArticleEntity

class SearchAdapter(
    private val moveToDetailCallback: (ArticleEntity) -> Unit
) : PagingDataAdapter<ArticleEntity, SearchViewHolder>(
    object : DiffUtil.ItemCallback<ArticleEntity>() {
        override fun areItemsTheSame(oldItem: ArticleEntity, newItem: ArticleEntity): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(
            oldItem: ArticleEntity,
            newItem: ArticleEntity
        ): Boolean {
            return oldItem == newItem
        }
    }
) {
    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        getItem(position)?.let { article ->
            holder.bind(article)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(parent, moveToDetailCallback)
    }
}