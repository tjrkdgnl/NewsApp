package com.hugh.navigator

import android.content.Context
import android.content.Intent
import com.hugh.entity.ArticleEntity

interface CategoryDetailNavigator {

    fun intent(context: Context, articleEntity: ArticleEntity): Intent
}