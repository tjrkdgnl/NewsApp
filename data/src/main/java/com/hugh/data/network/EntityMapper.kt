package com.hugh.data.network

import com.hugh.data.model.Article
import com.hugh.data.model.Articles
import com.hugh.domain.entity.ArticleEntity
import com.hugh.domain.entity.ArticlesEntity

fun Articles.toEntity(): ArticlesEntity {
    return ArticlesEntity(
        articles = this.articles.map { it.toEntity() }
    )
}

fun Article.toEntity(): ArticleEntity {
    return ArticleEntity(
        author = this.author ?: "",
        content = this.content,
        description = this.description,
        publishedAt = this.publishedAt,
        title = this.title,
        url = this.url,
        urlToImage = this.urlToImage
    )
}
