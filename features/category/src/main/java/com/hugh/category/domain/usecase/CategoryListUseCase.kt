package com.hugh.category.domain.usecase

import androidx.paging.PagingData
import com.hugh.category.domain.entity.ArticleEntity
import com.hugh.category.domain.state.CategoryType
import com.hugh.category.domain.state.CountryType
import kotlinx.coroutines.flow.Flow

internal interface CategoryListUseCase {

    fun getCategoryDetailArticles(
        categoryType: CategoryType,
        countryType: CountryType = CountryType.US
    ): Flow<PagingData<ArticleEntity>>
}