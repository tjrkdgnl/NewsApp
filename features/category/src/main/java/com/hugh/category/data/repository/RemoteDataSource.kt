package com.hugh.category.data.repository

import com.hugh.CategoryType
import com.hugh.category.data.network.CategoryApiService
import com.hugh.network.state.ArticlesState
import com.hugh.network.state.CountryType
import com.hugh.network.toEntity
import javax.inject.Inject

internal class RemoteDataSource @Inject constructor(
    private val apiService: CategoryApiService
) {
    suspend fun getCategoryList(
        categoryType: CategoryType,
        countryType: CountryType,
        page: Int,
        pageSize: Int
    ): ArticlesState {
        return runCatching {
            ArticlesState.Success(
                articlesEntity = apiService.getTopHeadlines(
                    country = countryType.toString(),
                    category = categoryType.toString(),
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