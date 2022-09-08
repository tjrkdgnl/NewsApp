package com.hugh.category.domain.repository

import com.hugh.category.domain.entity.ArticleEntity
import com.hugh.category.domain.state.ArticleState

internal interface CategoryDetailRepository {

    suspend fun insertArticle(article: ArticleEntity)

    suspend fun checkArticle(uid: String): ArticleState

    suspend fun deleteArticle(uid: String)
}