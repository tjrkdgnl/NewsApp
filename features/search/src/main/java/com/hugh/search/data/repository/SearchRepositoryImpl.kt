package com.hugh.search.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.hugh.coroutine.IoDispatcher
import com.hugh.entity.ArticleEntity
import com.hugh.network.Constant
import com.hugh.network.state.ArticlesState
import com.hugh.search.data.paging.SearchPagingSource
import com.hugh.search.domain.repository.SearchRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class SearchRepositoryImpl @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val remoteDataSource: RemoteDataSource
) : SearchRepository {

    override fun searchFlow(keyword: String): Flow<PagingData<ArticleEntity>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constant.INITIAL_LOAD_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { SearchPagingSource(this, keyword) }
        ).flow
    }

    override suspend fun search(keyword: String, page: Int, pageSize: Int): ArticlesState {
        return withContext(ioDispatcher) {
            remoteDataSource.search(
                keyword = keyword,
                page = page,
                pageSize = pageSize
            )
        }
    }
}