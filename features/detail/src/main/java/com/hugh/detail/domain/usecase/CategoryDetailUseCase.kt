package com.hugh.detail.domain.usecase

import com.hugh.detail.domain.state.ArticleState
import com.hugh.entity.ArticleEntity


internal interface CategoryDetailUseCase {

    suspend fun insertArticle(article: ArticleEntity)

    suspend fun checkArticle(uid: String): ArticleState

    suspend fun deleteArticle(id: String)
}