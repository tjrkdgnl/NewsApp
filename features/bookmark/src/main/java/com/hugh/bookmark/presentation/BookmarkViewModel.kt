package com.hugh.bookmark.presentation

import androidx.lifecycle.ViewModel
import com.hugh.bookmark.domain.usecase.BookmarkUseCase
import javax.inject.Inject

class BookmarkViewModel @Inject constructor(
    private val bookmarkUseCase: BookmarkUseCase
) : ViewModel() {

    val articlesFlow = bookmarkUseCase.getArticles()

}