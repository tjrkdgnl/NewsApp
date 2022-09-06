package com.hugh.category.domain.usecase

import com.hugh.category.domain.state.CategoryType

interface CategoryUseCase {

    fun getCategoryTypeList(): List<CategoryType>
}