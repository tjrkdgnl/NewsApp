package com.hugh.detail.data.repository

import com.hugh.coroutine.IoDispatcher
import com.hugh.detail.domain.repository.CategoryDetailRepository
import com.hugh.detail.domain.state.ArticleState
import com.hugh.entity.ArticleEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class CategoryDetailRepositoryImpl @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val localDataSource: LocalDataSource
) : CategoryDetailRepository {

    override suspend fun insertArticle(article: ArticleEntity) {
        localDataSource.insertArticle(article)
    }

    override suspend fun checkArticle(title: String): ArticleState {
        return withContext(ioDispatcher) {
            localDataSource.checkArticle(title)
        }
    }

    override suspend fun deleteArticle(title: String) {
        localDataSource.deleteArticle(title)
    }
}