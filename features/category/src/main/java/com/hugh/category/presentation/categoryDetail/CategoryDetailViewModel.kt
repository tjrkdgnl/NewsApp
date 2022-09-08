package com.hugh.category.presentation.categoryDetail

import androidx.lifecycle.*
import com.hugh.category.domain.entity.ArticleEntity
import com.hugh.category.domain.state.ArticleState
import com.hugh.category.domain.usecase.CategoryDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class CategoryDetailViewModel @Inject constructor(
    private val categoryDetailUseCase: CategoryDetailUseCase,
    private val bundle: SavedStateHandle
) : ViewModel() {
    private val _article = MutableLiveData<ArticleEntity>()
    val article: LiveData<ArticleEntity>
        get() = _article

    var bookmarkToggle = MutableStateFlow(false)

    init {
        val articleData = bundle.get<ArticleEntity>("article")

        articleData?.let {
            _article.value = it
        }

        viewModelScope.launch {
            articleData?.let { article ->
                val state = categoryDetailUseCase.checkArticle(article.title)

                when (state) {
                    is ArticleState.Success -> bookmarkToggle.emit(true)
                    is ArticleState.Failure -> {}
                }
            }
        }
    }

    fun toggleBookmark() {
        viewModelScope.launch {
            _article.value?.let {
                if (!bookmarkToggle.value) {
                    categoryDetailUseCase.insertArticle(it)
                    bookmarkToggle.emit(true)
                } else {
                    categoryDetailUseCase.deleteArticle(it.title)
                    bookmarkToggle.emit(false)
                }
            }
        }
    }
}