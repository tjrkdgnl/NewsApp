package com.hugh.search.data.network

import com.hugh.network.model.Articles
import retrofit2.http.GET
import retrofit2.http.Query

internal interface SearchApiService {

    @GET("everything/")
    suspend fun getEveryThing(
        @Query("q") keyword: String,
        @Query("from") from: String?,
        @Query("to") to: String?,
        @Query("sortedBy") sortType: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): Articles
}