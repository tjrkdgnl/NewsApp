package com.hugh.category.data.usecase

import com.hugh.category.domain.entity.ArticleEntity
import com.hugh.category.domain.repository.CategoryDetailRepository
import com.hugh.category.domain.state.ArticleState
import com.hugh.category.domain.usecase.CategoryDetailUseCase
import javax.inject.Inject

internal class CategoryDetailUseCaseImpl @Inject constructor(
    private val categoryDetailRepository: CategoryDetailRepository
) : CategoryDetailUseCase {

    override suspend fun insertArticle(article: ArticleEntity) {
        categoryDetailRepository.insertArticle(article)
    }

    override suspend fun checkArticle(title: String): ArticleState {
        return categoryDetailRepository.checkArticle(title)
    }

    override suspend fun deleteArticle(title: String) {
        categoryDetailRepository.deleteArticle(title)
    }
}