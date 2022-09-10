package com.hugh.top_news.data.usecase

import androidx.paging.PagingData
import com.hugh.entity.ArticleEntity
import com.hugh.network.state.CountryType
import com.hugh.top_news.domain.repository.TopNewsRepository
import com.hugh.top_news.domain.usecase.TopNewsUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TopNewsUseCaseImpl @Inject constructor(
    private val topNewsRepository: TopNewsRepository
) : TopNewsUseCase {

    override fun topNewsFlow(countryType: CountryType): Flow<PagingData<ArticleEntity>> {
        return topNewsRepository.topNewsFlow(countryType)
    }
}