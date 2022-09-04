package com.hugh.domain.repository

import com.hugh.domain.state.ArticleState

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