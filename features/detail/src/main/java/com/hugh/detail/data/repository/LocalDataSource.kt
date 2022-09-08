package com.hugh.detail.data.repository

import androidx.room.withTransaction
import com.hugh.detail.data.room.toEntity
import com.hugh.detail.data.room.toRoom
import com.hugh.detail.domain.state.ArticleState
import com.hugh.entity.ArticleEntity
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

    suspend fun checkArticle(title: String): ArticleState {
        return runCatching {
            ArticleState.Success(
                articleEntity = articleDao.checkArticle(title).toEntity()
            )
        }.getOrElse {
            ArticleState.Failure(
                throwable = it
            )
        }
    }

    suspend fun deleteArticle(title: String) {
        articleDataBase.withTransaction {
            articleDao.deleteArticle(title)
        }
    }
}