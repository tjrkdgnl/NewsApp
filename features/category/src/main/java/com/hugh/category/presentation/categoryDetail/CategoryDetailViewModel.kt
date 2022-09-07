package com.hugh.category.presentation.categoryDetail

import androidx.lifecycle.*
import com.hugh.category.domain.entity.ArticleEntity
import com.hugh.category.domain.usecase.ArticleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryDetailViewModel @Inject constructor(
    private val articleUseCase: ArticleUseCase,
    private val bundle: SavedStateHandle
) : ViewModel() {
    private val _article = MutableLiveData<ArticleEntity>()
    val article: LiveData<ArticleEntity>
        get() = _article

    var bookmarkToggle = false

    init {
        val articleData = bundle.get<ArticleEntity>("article")

        articleData?.let {
            _article.value = it
        }
    }

    fun toggleBookmark() {
        viewModelScope.launch {
            article.value?.let {
                bookmarkToggle = if (!bookmarkToggle) {
                    articleUseCase.insertArticle(it)
                    true
                } else {
                    articleUseCase.deleteArticle(it.uid)
                    false
                }
            }
        }
    }
}