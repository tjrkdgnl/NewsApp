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
}