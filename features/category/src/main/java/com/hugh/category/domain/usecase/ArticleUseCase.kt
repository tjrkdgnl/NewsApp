package com.hugh.category.domain.usecase

import com.hugh.category.domain.state.ArticleState
import com.hugh.category.domain.state.CategoryType
import com.hugh.category.domain.state.CountryType

interface ArticleUseCase {

    suspend fun getTopHeadlines(
        categoryType: CategoryType,
        countryType: CountryType
    ): ArticleState

    suspend fun getEveryThing(
        type: String,
        from: String? = null,
        to: String? = null,
        sortType: String = "popularity"
    ): ArticleState
}