package com.hugh.category.data.usecase

import com.hugh.category.domain.repository.ArticleRepository
import com.hugh.category.domain.state.ArticleState
import com.hugh.category.domain.state.CategoryType
import com.hugh.category.domain.state.CountryType
import com.hugh.category.domain.usecase.CategoryDetailUseCase
import javax.inject.Inject

class CategoryDetailUseCaseImpl @Inject constructor(
    private val articleRepository: ArticleRepository
) : CategoryDetailUseCase {

    override suspend fun getCategoryArticles(
        categoryType: CategoryType,
        countryType: CountryType
    ): ArticleState {
        return articleRepository.getTopHeadlines(categoryType, countryType)
    }
}