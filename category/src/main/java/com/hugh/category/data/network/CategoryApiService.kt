package com.hugh.category.data.network

import com.hugh.category.data.model.Articles
import retrofit2.http.GET
import retrofit2.http.Query

interface CategoryApiService {

    @GET("everything/")
    suspend fun getEveryThing(
        @Query("q") type: String,
        @Query("from") from: String?,
        @Query("to") to: String?,
        @Query("sortedBy") sortType: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): Articles

}