package com.hugh.category.data.network

import com.hugh.category.data.model.Article
import com.hugh.category.data.model.Articles
import com.hugh.category.domain.entity.ArticleEntity
import com.hugh.category.domain.entity.ArticlesEntity

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
