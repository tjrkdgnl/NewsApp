package com.hugh.top_news.presentation.adapter

import android.view.ViewGroup
import com.hugh.base.BaseViewHolder
import com.hugh.entity.ArticleEntity
import com.hugh.top_news.R
import com.hugh.top_news.databinding.ViewholderTopnewsItemBinding

class TopNewsViewHolder(
    parent: ViewGroup,
    private val moveToDetailCallback: (ArticleEntity) -> Unit
) : BaseViewHolder<ViewholderTopnewsItemBinding, ArticleEntity>(
    parent,
    R.layout.viewholder_topnews_item
) {

    init {
        binding.root.setOnClickListener {
            moveToDetailCallback(binding.article!!)
        }
    }

    override fun bind(item: ArticleEntity) {
        binding.article = item
    }
}