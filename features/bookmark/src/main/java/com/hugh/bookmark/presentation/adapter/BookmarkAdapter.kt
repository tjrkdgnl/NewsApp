package com.hugh.bookmark.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.hugh.entity.ArticleEntity

class BookmarkAdapter(private val moveCallback: (ArticleEntity) -> Unit) :
    ListAdapter<ArticleEntity, BookmarkViewHolder>(
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkViewHolder {
        return BookmarkViewHolder(parent, moveCallback)
    }

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}