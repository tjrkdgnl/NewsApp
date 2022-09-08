package com.hugh.network.state

import com.hugh.entity.ArticleEntity

sealed class ArticleState {
    data class Success(val articleEntity: ArticleEntity) : ArticleState()
    data class Failure(val throwable: Throwable) : ArticleState()
}
