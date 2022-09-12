package com.hugh.top_news.domain.usecase

import androidx.paging.PagingData
import com.hugh.entity.ArticleEntity
import com.hugh.network.state.CountryType
import kotlinx.coroutines.flow.Flow

internal interface TopNewsUseCase {

    fun topNewsFlow(countryType: CountryType): Flow<PagingData<ArticleEntity>>
}