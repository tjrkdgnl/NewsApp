package com.hugh.top_news.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.hugh.entity.ArticleEntity
import com.hugh.network.Constant
import com.hugh.network.state.ArticlesState
import com.hugh.network.state.CountryType
import com.hugh.top_news.data.paging.TopNewsPagingSource
import com.hugh.top_news.domain.repository.TopNewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TopNewsRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : TopNewsRepository {

    override fun topNewsFlow(countryType: CountryType): Flow<PagingData<ArticleEntity>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constant.INITIAL_LOAD_SIZE,
                enablePlaceholders = false
            ),
            initialKey = Constant.DEFAULT_PAGE_KEY,
            pagingSourceFactory = { TopNewsPagingSource(remoteDataSource, countryType) }
        ).flow
    }

    override suspend fun getTopNews(
        countryType: CountryType,
        page: Int,
        pageSize: Int
    ): ArticlesState {
        return remoteDataSource.getTopNews(
            countryType = countryType,
            page = page,
            pageSize = pageSize
        )
    }
}