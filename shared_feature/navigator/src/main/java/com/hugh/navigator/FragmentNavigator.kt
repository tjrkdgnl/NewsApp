package com.hugh.navigator

import android.content.Context
import androidx.navigation.NavController
import com.hugh.CategoryType
import com.hugh.entity.ArticleEntity

interface FragmentNavigator {

    fun moveToCategoryDetail(context: Context, articleEntity: ArticleEntity)
    fun categoryToCategoryList(categoryType: CategoryType, navController: NavController)
}