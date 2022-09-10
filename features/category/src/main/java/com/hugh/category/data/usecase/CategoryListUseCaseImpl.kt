package com.hugh.category.data.usecase

import androidx.paging.PagingData
import com.hugh.CategoryType
import com.hugh.category.domain.repository.CategoryRepository
import com.hugh.category.domain.usecase.CategoryListUseCase
import com.hugh.entity.ArticleEntity
import com.hugh.network.state.CountryType
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

internal class CategoryListUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
) : CategoryListUseCase {

    override fun getCategoryDetailArticles(
        categoryType: CategoryType,
        countryType: CountryType
    ): Flow<PagingData<ArticleEntity>> {
        return categoryRepository.getCategoryListFlow(categoryType, countryType)
    }
}