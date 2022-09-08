package com.hugh.callback

import com.hugh.CategoryType
import com.hugh.entity.ArticleEntity

interface FragmentNavigator {

    fun categoryListToCategoryDetail(articleEntity: ArticleEntity)
    fun bookmarkToCategoryDetail(articleEntity: ArticleEntity)
    fun categoryToCategoryList(categoryType: CategoryType)
}