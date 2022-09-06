package com.hugh.category.domain.usecase

import com.hugh.category.domain.state.ArticleState

interface ArticleUseCase {

    suspend fun getEveryThing(
        type: String,
        from: String? = null,
        to: String? = null,
        sortType: String = "popularity"
    ): ArticleState
}