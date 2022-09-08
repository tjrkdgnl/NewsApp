package com.hugh.category.domain.repository

import androidx.paging.PagingData
import com.hugh.CategoryType
import com.hugh.entity.ArticleEntity
import com.hugh.network.state.ArticlesState
import com.hugh.network.state.CountryType
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