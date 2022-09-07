package com.hugh.category.presentation.categoryList.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.hugh.category.domain.entity.ArticleEntity

class CategoryDetailPagingAdapter(
    private val moveArticleDetailCallback: (ArticleEntity) -> Unit
) : PagingDataAdapter<ArticleEntity, CategoryDetailViewHolder>(
    object : DiffUtil.ItemCallback<ArticleEntity>() {
        override fun areItemsTheSame(oldItem: ArticleEntity, newItem: ArticleEntity): Boolean {
            return oldItem.title == oldItem.title
        }

        override fun areContentsTheSame(
            oldItem: ArticleEntity,
            newItem: ArticleEntity
        ): Boolean {
            return oldItem == newItem
        }
    }
) {
    override fun onBindViewHolder(holder: CategoryDetailViewHolder, position: Int) {
        val item = getItem(position)

        if (item != null) {
            holder.bind(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryDetailViewHolder {
        return CategoryDetailViewHolder(parent, moveArticleDetailCallback)
    }
}