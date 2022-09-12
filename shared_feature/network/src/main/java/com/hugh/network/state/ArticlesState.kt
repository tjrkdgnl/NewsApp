package com.hugh.network.state

import com.hugh.entity.ArticlesEntity

sealed class ArticlesState {
    data class Success(val articlesEntity: ArticlesEntity) : ArticlesState()
    data class Failure(val throwable: Throwable) : ArticlesState()
}
