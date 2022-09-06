package com.hugh.category.domain.usecase

import androidx.paging.PagingData
import com.hugh.category.domain.entity.ArticleEntity
import com.hugh.category.domain.state.CategoryType
import com.hugh.category.domain.state.CountryType
import kotlinx.coroutines.flow.Flow

interface CategoryDetailUseCase {

    fun getCategoryDetailArticles(
        categoryType: CategoryType,
        countryType: CountryType = CountryType.KR
    ): Flow<PagingData<ArticleEntity>>
}