package com.hugh.category.presentation.category.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.hugh.category.domain.state.CategoryType

class CategoryAdapter(private val moveCallback: (CategoryType) -> Unit) :
    ListAdapter<CategoryType, CategoryViewHolder>(object : DiffUtil.ItemCallback<CategoryType>() {
        override fun areItemsTheSame(oldItem: CategoryType, newItem: CategoryType): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CategoryType, newItem: CategoryType): Boolean {
            return oldItem == newItem
        }
    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(parent, moveCallback)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}