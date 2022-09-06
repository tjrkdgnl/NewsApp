package com.hugh.category.presentation.categoryDetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.hugh.category.domain.state.CategoryType
import com.hugh.category.domain.usecase.CategoryDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CategoryDetailViewModel @Inject constructor(
    private val categoryDetailUseCase: CategoryDetailUseCase,
    private val bundle: SavedStateHandle
) : ViewModel() {

    val categoryType = bundle.get<CategoryType>("categoryType")

    val categoryDetailFlow = categoryDetailUseCase.getCategoryDetailArticles(
        categoryType = categoryType!!
    ).cachedIn(viewModelScope)

}