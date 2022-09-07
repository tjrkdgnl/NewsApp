package com.hugh.category.presentation.categoryList.adapter

import android.view.ViewGroup
import com.hugh.base.BaseViewHolder
import com.hugh.category.R
import com.hugh.category.databinding.ViewholderCategoryDetailBinding
import com.hugh.category.domain.entity.ArticleEntity

class CategoryDetailViewHolder(parent: ViewGroup) :
    BaseViewHolder<ViewholderCategoryDetailBinding, ArticleEntity>(
        parent, R.layout.viewholder_category_list
    ) {

    override fun bind(item: ArticleEntity) {
        binding.article = item
    }
}