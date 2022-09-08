package com.hugh.bookmark.domain.usecase

import com.hugh.entity.ArticleEntity
import kotlinx.coroutines.flow.Flow

interface BookmarkUseCase {

    fun getArticles(): Flow<List<ArticleEntity>>
}