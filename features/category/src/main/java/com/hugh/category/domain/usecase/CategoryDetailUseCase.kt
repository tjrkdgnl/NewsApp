package com.hugh.category.domain.usecase

import com.hugh.category.domain.state.ArticleState
import com.hugh.category.domain.state.CategoryType
import com.hugh.category.domain.state.CountryType

interface CategoryDetailUseCase {

    suspend fun getCategoryArticles(
        categoryType: CategoryType,
        countryType: CountryType = CountryType.KR
    ): ArticleState
}