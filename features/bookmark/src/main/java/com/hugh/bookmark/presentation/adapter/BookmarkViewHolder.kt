package com.hugh.bookmark.presentation.adapter

import android.view.ViewGroup
import com.hugh.base.BaseViewHolder
import com.hugh.bookmark.R
import com.hugh.bookmark.databinding.ViewholderBookmarkItemBinding
import com.hugh.entity.ArticleEntity

class BookmarkViewHolder(
    parent: ViewGroup,
    private val moveCallback: (ArticleEntity) -> Unit
) : BaseViewHolder<ViewholderBookmarkItemBinding, ArticleEntity>(
    parent,
    R.layout.viewholder_bookmark_item
) {

    init {
        binding.root.setOnClickListener {
            moveCallback(binding.article!!)
        }
    }

    override fun bind(item: ArticleEntity) {
        binding.article = item
    }
}