package com.hugh.navigator

import android.content.Context
import android.content.Intent
import com.hugh.CategoryType

interface CategoryListNavigator {

    fun moveToCategoryList(context: Context, categoryType: CategoryType): Intent
}