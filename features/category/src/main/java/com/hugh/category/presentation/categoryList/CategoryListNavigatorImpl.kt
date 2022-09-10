package com.hugh.category.presentation.categoryList

import android.content.Context
import android.content.Intent
import com.hugh.CategoryType
import com.hugh.navigator.CategoryListNavigator
import javax.inject.Inject

class CategoryListNavigatorImpl @Inject constructor() : CategoryListNavigator {

    override fun moveToCategoryList(context: Context, categoryType: CategoryType): Intent {
        return Intent(context, CategoryListActivity::class.java).apply {
            putExtra("categoryType", categoryType)
        }
    }
}