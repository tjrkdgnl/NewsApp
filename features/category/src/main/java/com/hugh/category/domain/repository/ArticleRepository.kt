package com.hugh.category.domain.repository

import com.hugh.category.domain.state.ArticleState
import com.hugh.category.domain.state.CategoryType
import com.hugh.category.domain.state.CountryType

interface ArticleRepository {

    suspend fun getTopHeadlines(
        category: CategoryType,
        countryType: CountryType = CountryType.KR
    ): ArticleState

    suspend fun getEverything(
        type: String,
        from: String?,
        to: String?,
        page: Int = 1,
        pageSize: Int = 30,
        sortType: String
    ): ArticleState

    fun getCategoryTypeList(): List<CategoryType>
}