package com.hugh.category.data.repository

import androidx.room.withTransaction
import com.hugh.category.data.room.ArticleDataBase
import com.hugh.category.data.room.toEntity
import com.hugh.category.data.room.toRoom
import com.hugh.category.domain.entity.ArticleEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class LocalDataSource @Inject constructor(
    private val articleDataBase: ArticleDataBase
) {

    private val articleDao = articleDataBase.articleDao()

    suspend fun insertArticle(article: ArticleEntity) {
        articleDataBase.withTransaction {
            articleDao.insertArticle(article.toRoom())
        }
    }

    suspend fun deleteArticle(id: String) {
        articleDataBase.withTransaction {
            articleDao.deleteArticle(id)
        }
    }

    fun getArticleFlow(): Flow<ArticleEntity> {
        return articleDao.getArticleFlow().map { it.toEntity() }
    }
}