package com.hugh.category.domain.usecase

import com.hugh.CategoryType

internal interface CategoryUseCase {

    fun getCategoryTypeList(): List<CategoryType>
}