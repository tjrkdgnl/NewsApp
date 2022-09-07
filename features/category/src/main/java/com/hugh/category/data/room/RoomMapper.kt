package com.hugh.category.data.room

import com.hugh.category.data.room.model.RoomArticle
import com.hugh.category.domain.entity.ArticleEntity


fun ArticleEntity.toRoom(): RoomArticle {
    return RoomArticle(
        id = null,
        uid = this.uid,
        title = this.title,
        author = this.author,
        date = this.publishedAt,
        content = this.content,
        urlToImage = this.urlToImage
    )
}

fun RoomArticle.toEntity(): ArticleEntity {
    return ArticleEntity.EMPTY.copy(
        uid = this.uid,
        author = this.author,
        content = this.content,
        publishedAt = this.date,
        title = this.title,
        urlToImage = this.urlToImage
    )
}