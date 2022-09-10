package com.hugh.top_news.domain.repository

import androidx.paging.PagingData
import com.hugh.entity.ArticleEntity
import com.hugh.network.state.ArticlesState
import com.hugh.network.state.CountryType
import kotlinx.coroutines.flow.Flow

interface TopNewsRepository {

    fun topNewsFlow(  countryType: CountryType): Flow<PagingData<ArticleEntity>>
    suspend fun getTopNews(countryType: CountryType, page: Int, pageSize: Int): ArticlesState
}