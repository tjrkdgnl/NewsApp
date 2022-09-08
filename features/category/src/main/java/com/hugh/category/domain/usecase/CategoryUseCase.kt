package com.hugh.category.domain.usecase

import com.hugh.category.domain.state.CategoryType

internal interface CategoryUseCase {

    fun getCategoryTypeList(): List<CategoryType>
}