package com.hugh.category.presentation.category

import androidx.lifecycle.ViewModel
import com.hugh.category.domain.state.CategoryType
import com.hugh.category.domain.usecase.CategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class ArticleViewModel @Inject constructor(
    private val categoryUseCase: CategoryUseCase
) : ViewModel() {

    fun createCategoryTypeList(): List<CategoryType> {
        return categoryUseCase.getCategoryTypeList()
    }
}