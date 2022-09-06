package com.hugh.category.presentation.categoryDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hugh.category.domain.state.CategoryType
import com.hugh.category.domain.usecase.CategoryDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryDetailViewModel @Inject constructor(
    private val categoryDetailUseCase: CategoryDetailUseCase
) : ViewModel() {


    fun sample() {
        viewModelScope.launch {
            categoryDetailUseCase.getCategoryArticles(
                categoryType = CategoryType.SPORTS
            )
        }
    }
}