package com.hugh.data.repository

import com.hugh.data.di.IoDispatcher
import com.hugh.domain.state.ArticleState
import com.hugh.domain.repository.ArticleRepository
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