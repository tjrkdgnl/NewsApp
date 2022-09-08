package com.hugh.bookmark.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.hugh.bookmark.domain.entity.ArticleEntity

class BookmarkAdapter : ListAdapter<ArticleEntity, BookmarkViewHolder>(
    object : DiffUtil.ItemCallback<ArticleEntity>() {
        override fun areItemsTheSame(oldItem: ArticleEntity, newItem: ArticleEntity): Boolean {
            return oldItem.uid == newItem.uid
        }

        override fun areContentsTheSame(oldItem: ArticleEntity, newItem: ArticleEntity): Boolean {
            return oldItem == newItem
        }
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkViewHolder {
        return BookmarkViewHolder(parent)
    }

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}