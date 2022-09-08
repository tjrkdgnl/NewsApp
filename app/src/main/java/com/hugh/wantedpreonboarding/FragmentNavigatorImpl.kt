package com.hugh.wantedpreonboarding

import android.content.Context
import androidx.navigation.NavController
import com.hugh.CategoryType
import com.hugh.category.presentation.category.CategoryFragmentDirections
import com.hugh.entity.ArticleEntity
import com.hugh.navigator.CategoryDetailNavigator
import com.hugh.navigator.FragmentNavigator
import javax.inject.Inject

class FragmentNavigatorImpl @Inject constructor(
    private val categoryDetailNavigator: CategoryDetailNavigator
) : FragmentNavigator {
    override fun moveToCategoryDetail(context: Context, articleEntity: ArticleEntity) {
        val intent = categoryDetailNavigator.intent(context, articleEntity)
        context.startActivity(intent)
    }

    override fun categoryToCategoryList(categoryType: CategoryType, navController: NavController) {
        val action = CategoryFragmentDirections.actionCategoryToCategoryList(categoryType)
        navController.navigate(action)
    }
}