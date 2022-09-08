package com.hugh.bookmark.presentation.adapter

import android.view.ViewGroup
import com.hugh.base.BaseViewHolder
import com.hugh.bookmark.R
import com.hugh.bookmark.databinding.ViewholderBookmarkItemBinding
import com.hugh.bookmark.domain.entity.ArticleEntity

class BookmarkViewHolder(
    parent: ViewGroup
) : BaseViewHolder<ViewholderBookmarkItemBinding, ArticleEntity>(
    parent,
    R.layout.viewholder_bookmark_item
) {

    override fun bind(item: ArticleEntity) {
        binding.article = item
    }
}