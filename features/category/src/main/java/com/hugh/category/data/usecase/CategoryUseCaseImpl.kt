package com.hugh.category.data.usecase

import com.hugh.category.domain.repository.ArticleRepository
import com.hugh.category.domain.state.CategoryType
import com.hugh.category.domain.usecase.CategoryUseCase
import javax.inject.Inject

class CategoryUseCaseImpl @Inject constructor(
    private val articleRepository: ArticleRepository
) : CategoryUseCase {

    override fun getCategoryTypeList(): List<CategoryType> {
        return articleRepository.getCategoryTypeList()
    }
}