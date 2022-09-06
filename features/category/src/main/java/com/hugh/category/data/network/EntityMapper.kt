package com.hugh.category.data.network

import com.hugh.category.data.model.Article
import com.hugh.category.data.model.Articles
import com.hugh.category.domain.entity.ArticleEntity
import com.hugh.category.domain.entity.ArticlesEntity
import com.hugh.dateformatter.DateFormatter

fun Articles.toEntity(): ArticlesEntity {
    return ArticlesEntity(
        articles = this.articles
            .filterNot { it.urlToImage == null || it.description == null }
            .map { it.toEntity() }
    )
}

fun Article.toEntity(): ArticleEntity {
    return ArticleEntity(
        author = this.author ?: "",
        content = this.content ?: "",
        description = this.description ?: "",
        publishedAt = if(this.publishedAt !=null) DateFormatter.getDifferentDate(this.publishedAt) else "",
        title = this.title ?: "",
        url = this.url ?: "",
        urlToImage = this.urlToImage ?: ""
    )
}
