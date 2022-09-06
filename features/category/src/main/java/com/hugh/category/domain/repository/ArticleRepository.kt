package com.hugh.category.domain.repository

import com.hugh.category.domain.state.ArticleState

interface ArticleRepository {

    suspend fun getEverything(
        type: String,
        from: String?,
        to: String?,
        page: Int = 1,
        pageSize: Int = 30,
        sortType: String
    ): ArticleState

}