package com.hugh.search.domain.usecase

import androidx.paging.PagingData
import com.hugh.entity.ArticleEntity
import kotlinx.coroutines.flow.Flow

internal interface SearchUseCase {

    fun search(keyword: String): Flow<PagingData<ArticleEntity>>
}