package com.hugh.bookmark.domain.repository

import com.hugh.entity.ArticleEntity
import kotlinx.coroutines.flow.Flow

interface BookmarkRepository {

    fun getArticles(): Flow<List<ArticleEntity>>
}