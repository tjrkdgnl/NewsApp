package com.hugh.category.domain.state

import com.hugh.category.domain.entity.ArticleEntity

internal sealed class ArticleState {
    data class Success(val articleEntity: ArticleEntity) : ArticleState()
    data class Failure(val throwable: Throwable) : ArticleState()
}
