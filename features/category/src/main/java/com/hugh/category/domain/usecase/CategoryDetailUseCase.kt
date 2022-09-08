package com.hugh.category.domain.usecase

import com.hugh.category.domain.entity.ArticleEntity
import com.hugh.category.domain.state.ArticleState


internal interface CategoryDetailUseCase {

    suspend fun insertArticle(article: ArticleEntity)

    suspend fun checkArticle(uid: String): ArticleState

    suspend fun deleteArticle(id: String)
}