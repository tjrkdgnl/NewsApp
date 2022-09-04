package com.hugh.presentation.articles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hugh.domain.state.ArticleState.Success
import com.hugh.domain.state.ArticleState.Failure
import com.hugh.domain.usecase.ArticleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(
    private val articleUseCase: ArticleUseCase
) : ViewModel() {

    val errorFlow = MutableSharedFlow<Throwable>()

    fun getEveryThing(type: String) {
        viewModelScope.launch {
            val state = articleUseCase.getEveryThing(
                type = type
            )

            when (state) {
                is Success -> {
                    state.articlesEntity
                }
                is Failure -> {
                    errorFlow.emit(state.throwable)
                }
            }
        }
    }
}