package com.hugh.bookmark.presentation

import androidx.lifecycle.ViewModel
import com.hugh.bookmark.domain.usecase.BookmarkUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(
    private val bookmarkUseCase: BookmarkUseCase
) : ViewModel() {

    val articlesFlow = bookmarkUseCase.getArticles()

}