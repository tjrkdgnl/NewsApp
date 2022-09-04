package com.hugh.category.data.repository

import com.hugh.category.domain.state.ArticleState
import com.hugh.category.domain.repository.ArticleRepository
import com.hugh.coroutine.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val remoteDataSource: RemoteDataSource
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
}