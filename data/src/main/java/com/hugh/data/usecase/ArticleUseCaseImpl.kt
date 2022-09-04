package com.hugh.data.usecase

import com.hugh.domain.state.ArticleState
import com.hugh.domain.repository.ArticleRepository
import com.hugh.domain.usecase.ArticleUseCase
import javax.inject.Inject

class ArticleUseCaseImpl @Inject constructor(
    private val articleRepository: ArticleRepository
) : ArticleUseCase {

    override suspend fun getEveryThing(
        type: String,
        from: String?,
        to: String?,
        sortType: String
    ): ArticleState {
        return articleRepository.getEverything(
            type = type,
            from = from,
            to = to,
            sortType = sortType
        )
    }
}