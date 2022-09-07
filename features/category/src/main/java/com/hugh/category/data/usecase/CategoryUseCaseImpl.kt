package com.hugh.category.data.usecase

import com.hugh.category.domain.repository.CategoryRepository
import com.hugh.category.domain.state.CategoryType
import com.hugh.category.domain.usecase.CategoryUseCase
import javax.inject.Inject

internal class CategoryUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
) : CategoryUseCase {

    override fun getCategoryTypeList(): List<CategoryType> {
        return categoryRepository.getCategoryTypeList()
    }
}