package com.hugh.category.presentation.categoryList

import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.hugh.CategoryType
import com.hugh.category.domain.usecase.CategoryListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class CategoryListViewModel @Inject constructor(
    private val categoryListUseCase: CategoryListUseCase,
    private val bundle: SavedStateHandle
) : ViewModel() {

    val categoryType = bundle.get<CategoryType>("categoryType") ?: CategoryType.NONE

    val retryFlow = MutableSharedFlow<Boolean>()

    val categoryDetailFlow = categoryListUseCase.getCategoryDetailArticles(
        categoryType = categoryType
    ).cachedIn(viewModelScope)

    fun retry() {
        viewModelScope.launch {
            retryFlow.emit(true)
        }
    }

    fun getCategoryName(): String {
        return when (categoryType) {
            CategoryType.BUSINESS -> "비즈니스"
            CategoryType.ENTERTAINMENT -> "엔터테인먼트"
            CategoryType.GENERAL -> "제네럴"
            CategoryType.HEALTH -> "헬스"
            CategoryType.SCIENCE -> "사이언스"
            CategoryType.SPORTS -> "스포츠"
            CategoryType.TECHNOLOGY -> "테크놀로지"
            CategoryType.NONE -> ""
        }
    }
}