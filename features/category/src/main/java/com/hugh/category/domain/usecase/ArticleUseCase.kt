package com.hugh.category.domain.usecase

import com.hugh.category.domain.entity.ArticleEntity
import com.hugh.category.domain.state.ArticleState
import kotlinx.coroutines.flow.Flow

interface ArticleUseCase {

    suspend fun getEveryThing(
        type: String,
        from: String? = null,
        to: String? = null,
        sortType: String = "popularity"
    ): ArticleState

    suspend fun insertArticle(article: ArticleEntity)

    suspend fun deleteArticle(id: String)

    suspend fun getArticleFlow(): Flow<ArticleEntity>
}