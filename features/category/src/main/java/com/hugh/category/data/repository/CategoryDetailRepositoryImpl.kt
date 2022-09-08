package com.hugh.category.data.repository

import com.hugh.category.domain.entity.ArticleEntity
import com.hugh.category.domain.repository.CategoryDetailRepository
import com.hugh.category.domain.state.ArticleState
import com.hugh.coroutine.IoDispatcher
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