package com.hugh.bookmark.data.repository

import com.hugh.bookmark.data.toEntity
import com.hugh.bookmark.domain.entity.ArticleEntity
import com.hugh.bookmark.domain.repository.BookmarkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BookmarkRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : BookmarkRepository {

    override fun getArticles(): Flow<List<ArticleEntity>> {
        return localDataSource.getArticles().map { articles ->
            articles.map { roomArticle ->
                roomArticle.toEntity()
            }
        }
    }
}