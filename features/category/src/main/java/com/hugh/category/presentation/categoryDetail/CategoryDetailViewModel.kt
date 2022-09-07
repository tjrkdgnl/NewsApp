package com.hugh.category.presentation.categoryDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.hugh.category.domain.entity.ArticleEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CategoryDetailViewModel @Inject constructor(
    private val bundle: SavedStateHandle
) : ViewModel() {
    private val _article = MutableLiveData<ArticleEntity>()
    val article: LiveData<ArticleEntity>
        get() = _article

    init {
        val articleData = bundle.get<ArticleEntity>("article")

        articleData?.let {
            _article.value = it
        }
    }
}