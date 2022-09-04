package com.hugh.domain.state

import com.hugh.domain.entity.ArticlesEntity

sealed class ArticleState {
    data class Success(val articlesEntity: ArticlesEntity) : ArticleState()
    data class Failure(val throwable: Throwable) : ArticleState()
}
