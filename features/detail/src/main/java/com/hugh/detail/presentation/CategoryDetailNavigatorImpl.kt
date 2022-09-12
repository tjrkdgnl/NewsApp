package com.hugh.detail.presentation

import android.content.Context
import android.content.Intent
import com.hugh.entity.ArticleEntity
import com.hugh.navigator.CategoryDetailNavigator
import javax.inject.Inject

class CategoryDetailNavigatorImpl @Inject constructor() : CategoryDetailNavigator {
    override fun intent(context: Context, articleEntity: ArticleEntity): Intent {
        return Intent(context, CategoryDetail::class.java).apply {
            putExtra("article",articleEntity)
        }
    }
}