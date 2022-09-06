package com.hugh.category.presentation.categoryDetail

import androidx.lifecycle.*
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

    private val _retryState = MutableLiveData(false)
    val retryState: LiveData<Boolean>
        get() = _retryState

    val categoryDetailFlow = categoryDetailUseCase.getCategoryDetailArticles(
        categoryType = categoryType!!
    ).cachedIn(viewModelScope)

    fun retry() {
        _retryState.value = true
    }

    fun retryInit() {
        _retryState.value = false
    }
}