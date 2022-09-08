package com.hugh.search.data.usecase

import androidx.paging.PagingData
import com.hugh.entity.ArticleEntity
import com.hugh.search.domain.repository.SearchRepository
import com.hugh.search.domain.usecase.SearchUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchUseCaseImpl @Inject constructor(
    private val searchRepository: SearchRepository
) : SearchUseCase {

    override fun search(keyword: String): Flow<PagingData<ArticleEntity>> {
        return searchRepository.searchFlow(keyword)
    }
}