package com.hugh.category.data.repository

import com.hugh.category.domain.state.ArticleState
import com.hugh.category.domain.repository.ArticleRepository
import com.hugh.category.domain.state.CategoryType
import com.hugh.category.domain.state.CountryType
import com.hugh.coroutine.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val remoteDataSource: RemoteDataSource
) : ArticleRepository {

    override suspend fun getTopHeadlines(
        category: CategoryType,
        countryType: CountryType
    ): ArticleState {
        return withContext(ioDispatcher) {
            remoteDataSource.getTopHeadLines(category, countryType)
        }
    }

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