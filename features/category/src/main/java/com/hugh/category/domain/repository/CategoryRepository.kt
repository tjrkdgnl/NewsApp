package com.hugh.category.domain.repository

import androidx.paging.PagingData
import com.hugh.category.domain.entity.ArticleEntity
import com.hugh.category.domain.state.ArticleState
import com.hugh.category.domain.state.CategoryType
import com.hugh.category.domain.state.CountryType
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {

    fun getCategoryDetailFlow(
        category: CategoryType,
        countryType: CountryType
    ): Flow<PagingData<ArticleEntity>>

    suspend fun getCategoryDetailList(
        category: CategoryType,
        countryType: CountryType,
        page: Int,
        pageSize: Int
    ): ArticleState

    fun getCategoryTypeList(): List<CategoryType>
}