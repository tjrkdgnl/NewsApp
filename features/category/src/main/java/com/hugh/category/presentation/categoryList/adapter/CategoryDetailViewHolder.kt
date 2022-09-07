package com.hugh.category.presentation.categoryList.adapter

import android.view.ViewGroup
import com.hugh.base.BaseViewHolder
import com.hugh.category.R
import com.hugh.category.databinding.ViewholderCategoryListBinding
import com.hugh.category.domain.entity.ArticleEntity

class CategoryDetailViewHolder(
    parent: ViewGroup,
    private val moveArticleDetailCallback: (ArticleEntity) -> Unit
) : BaseViewHolder<ViewholderCategoryListBinding, ArticleEntity>(parent, R.layout.viewholder_category_list) {

    init {
        binding.root.setOnClickListener {
            moveArticleDetailCallback(binding.article!!)
        }
    }

    override fun bind(item: ArticleEntity) {
        binding.article = item
    }
}