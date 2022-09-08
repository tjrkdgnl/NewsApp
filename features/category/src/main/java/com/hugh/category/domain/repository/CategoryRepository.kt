package com.hugh.category.domain.repository

import androidx.paging.PagingData
import com.hugh.category.domain.entity.ArticleEntity
import com.hugh.category.domain.state.ArticlesState
import com.hugh.category.domain.state.CategoryType
import com.hugh.category.domain.state.CountryType
import kotlinx.coroutines.flow.Flow

internal interface CategoryRepository {

    fun getCategoryListFlow(
        category: CategoryType,
        countryType: CountryType
    ): Flow<PagingData<ArticleEntity>>

    suspend fun getCategoryList(
        category: CategoryType,
        countryType: CountryType,
        page: Int,
        pageSize: Int
    ): ArticlesState

    fun getCategoryTypeList(): List<CategoryType>
}