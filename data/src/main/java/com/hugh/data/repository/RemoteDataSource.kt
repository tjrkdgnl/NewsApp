package com.hugh.data.repository

import com.hugh.data.network.ApiService
import com.hugh.data.network.toEntity
import com.hugh.domain.state.ArticleState
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getEverything(
        type: String,
        from: String?,
        to: String?,
        page: Int,
        pageSize: Int,
        sortType: String
    ): ArticleState {
        return runCatching {
            ArticleState.Success(
                articlesEntity = apiService.getEveryThing(
                    type, from, to, sortType, page, pageSize
                ).toEntity()
            )
        }.getOrElse {
            ArticleState.Failure(
                throwable = it
            )
        }
    }
}