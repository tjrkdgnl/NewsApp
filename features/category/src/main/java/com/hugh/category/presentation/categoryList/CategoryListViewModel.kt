package com.hugh.category.presentation.categoryList

import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.hugh.CategoryType
import com.hugh.category.domain.usecase.CategoryListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class CategoryListViewModel @Inject constructor(
    private val categoryListUseCase: CategoryListUseCase,
    private val bundle: SavedStateHandle
) : ViewModel() {

    val categoryType = bundle.get<CategoryType>("categoryType") ?: CategoryType.NONE

    private val _retryState = MutableLiveData(false)
    val retryState: LiveData<Boolean>
        get() = _retryState

    val categoryDetailFlow = categoryListUseCase.getCategoryDetailArticles(
        categoryType = categoryType
    ).cachedIn(viewModelScope)

    fun retry() {
        _retryState.value = true
    }

    fun retryInit() {
        _retryState.value = false
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