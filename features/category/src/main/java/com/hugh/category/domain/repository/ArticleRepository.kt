package com.hugh.category.domain.repository

import com.hugh.category.domain.entity.ArticleEntity
import com.hugh.category.domain.state.ArticleState

internal interface ArticleRepository {

    suspend fun getEverything(
        type: String,
        from: String?,
        to: String?,
        page: Int = 1,
        pageSize: Int = 30,
        sortType: String
    ): ArticleState

    suspend fun insertArticle(article:ArticleEntity)

    suspend fun deleteArticle(uid:String)
}