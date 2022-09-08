package com.hugh.category.data.repository

import com.hugh.category.domain.entity.ArticleEntity
import com.hugh.category.domain.repository.ArticleRepository
import com.hugh.category.domain.state.ArticleState
import com.hugh.coroutine.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class ArticleRepositoryImpl @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : ArticleRepository {

    override suspend fun getEverything(
        type: String,
        from: String?,
        to: String?,
        page: Int,
        pageSize: Int,
        sortType: String
    ): ArticleState {
        return withContext(ioDispatcher) {
            remoteDataSource.getEverything(type, from, to, page, pageSize, sortType)
        }
    }

    override suspend fun insertArticle(article: ArticleEntity) {
        localDataSource.insertArticle(article)
    }

    override suspend fun deleteArticle(uid: String) {
        localDataSource.deleteArticle(uid)
    }

    override fun getArticleFlow(): Flow<ArticleEntity> {
        return localDataSource.getArticleFlow()
    }
}