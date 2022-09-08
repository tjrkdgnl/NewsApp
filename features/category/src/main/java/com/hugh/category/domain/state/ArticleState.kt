package com.hugh.category.domain.state

import com.hugh.category.domain.entity.ArticlesEntity

internal sealed class ArticleState {
    data class Success(val articlesEntity: ArticlesEntity) : ArticleState()
    data class Failure(val throwable: Throwable) : ArticleState()
}
