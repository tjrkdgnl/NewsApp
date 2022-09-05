package com.hugh.category.presentation.category.adapter

import android.view.ViewGroup
import com.hugh.base.BaseViewHolder
import com.hugh.category.R
import com.hugh.category.databinding.ViewholderCategoryBinding
import com.hugh.category.domain.state.CategoryType

class CategoryViewHolder(
    parent: ViewGroup,
    private val moveCallback: (CategoryType) -> Unit
) :
    BaseViewHolder<ViewholderCategoryBinding, CategoryType>(parent, R.layout.viewholder_category) {

    init {
        binding.root.setOnClickListener {
            moveCallback(binding.categoryType!!)
        }
    }

    override fun bind(item: CategoryType) {
        binding.categoryType = item
    }
}