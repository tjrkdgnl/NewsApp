package com.hugh.top_news.data.network

import com.hugh.network.model.Articles
import retrofit2.http.GET
import retrofit2.http.Query

interface TopNewsApi {

    @GET("top-headlines/")
    suspend fun getTopHeadlines(
        @Query("country") country: String?,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ) : Articles
}