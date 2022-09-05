package com.hugh.category.presentation.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hugh.category.domain.state.ArticleState.Success
import com.hugh.category.domain.state.ArticleState.Failure
import com.hugh.category.domain.state.CategoryType
import com.hugh.category.domain.usecase.ArticleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(
    private val articleUseCase: ArticleUseCase
) : ViewModel() {

    fun createCategoryTypeList(): List<CategoryType> {
        return listOf(
            CategoryType.BUSINESS,
            CategoryType.ENTERTAINMENT,
            CategoryType.GENERAL,
            CategoryType.SCIENCE,
            CategoryType.HEALTH,
            CategoryType.SPORTS,
            CategoryType.TECHNOLOGY
        )
    }
}