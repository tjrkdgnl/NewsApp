package com.hugh.search.domain.repository

import androidx.paging.PagingData
import com.hugh.entity.ArticleEntity
import com.hugh.network.state.ArticlesState
import kotlinx.coroutines.flow.Flow

internal interface SearchRepository {

    fun searchFlow(keyword: String): Flow<PagingData<ArticleEntity>>

    suspend fun search(keyword: String, page: Int, pageSize: Int): ArticlesState
}