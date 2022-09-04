package com.hugh.category.data.repository

import com.hugh.category.data.network.CategoryApiService
import com.hugh.category.data.network.toEntity
import com.hugh.category.domain.state.ArticleState
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: CategoryApiService
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