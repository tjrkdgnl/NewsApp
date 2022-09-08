package com.hugh.search.data.repository

import com.hugh.network.state.ArticlesState
import com.hugh.network.toEntity
import com.hugh.search.data.network.SearchApiService
import javax.inject.Inject


internal class RemoteDataSource @Inject constructor(
    private val searchApiService: SearchApiService
) {
    suspend fun search(keyword: String, page: Int, pageSize: Int): ArticlesState {
        return runCatching {
            ArticlesState.Success(
                articlesEntity = searchApiService.getEveryThing(
                    keyword = keyword,
                    from = null,
                    to = null,
                    sortType = "",
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