package com.hugh.detail.data.usecase

import com.hugh.detail.domain.repository.CategoryDetailRepository
import com.hugh.detail.domain.state.ArticleState
import com.hugh.detail.domain.usecase.CategoryDetailUseCase
import com.hugh.entity.ArticleEntity
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