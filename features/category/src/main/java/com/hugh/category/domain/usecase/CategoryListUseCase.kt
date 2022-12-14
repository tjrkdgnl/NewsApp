package com.hugh.category.domain.usecase

import androidx.paging.PagingData
import com.hugh.CategoryType
import com.hugh.entity.ArticleEntity
import com.hugh.network.state.CountryType
import kotlinx.coroutines.flow.Flow

internal interface CategoryListUseCase {

    fun getCategoryDetailArticles(
        categoryType: CategoryType,
        countryType: CountryType = CountryType.US
    ): Flow<PagingData<ArticleEntity>>
}