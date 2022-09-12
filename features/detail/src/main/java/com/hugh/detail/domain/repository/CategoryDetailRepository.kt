package com.hugh.detail.domain.repository

import com.hugh.detail.domain.state.ArticleState
import com.hugh.entity.ArticleEntity

internal interface CategoryDetailRepository {

    suspend fun insertArticle(article: ArticleEntity)

    suspend fun checkArticle(title: String): ArticleState

    suspend fun deleteArticle(title: String)
}