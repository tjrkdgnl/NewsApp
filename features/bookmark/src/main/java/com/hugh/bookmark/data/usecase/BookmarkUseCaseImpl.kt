package com.hugh.bookmark.data.usecase

import com.hugh.bookmark.domain.repository.BookmarkRepository
import com.hugh.bookmark.domain.usecase.BookmarkUseCase
import com.hugh.entity.ArticleEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BookmarkUseCaseImpl @Inject constructor(
    private val bookmarkRepository: BookmarkRepository
) : BookmarkUseCase {

    override fun getArticles(): Flow<List<ArticleEntity>> {
        return bookmarkRepository.getArticles()
    }
}