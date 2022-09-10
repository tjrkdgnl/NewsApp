package com.hugh.top_news.data.repository

import com.hugh.network.state.ArticlesState
import com.hugh.network.state.CountryType
import com.hugh.network.toEntity
import com.hugh.top_news.data.network.TopNewsApi
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val topNewsApi: TopNewsApi
) {


    suspend fun getTopNews(countryType: CountryType,page: Int, pageSize: Int): ArticlesState {
        return runCatching {
            ArticlesState.Success(
                articlesEntity = topNewsApi.getTopHeadlines(
                    country = countryType.toString(),
                    page = page,
                    pageSize = pageSize
                ).toEntity()
            )
        }.getOrElse {
            ArticlesState.Failure(
                throwable = it
            )
        }
    }
}