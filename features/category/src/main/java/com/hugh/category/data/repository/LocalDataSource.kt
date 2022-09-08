package com.hugh.category.data.repository

import androidx.room.withTransaction
import com.hugh.category.data.room.toRoom
import com.hugh.category.domain.entity.ArticleEntity
import com.hugh.room.ArticleDataBase
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
}