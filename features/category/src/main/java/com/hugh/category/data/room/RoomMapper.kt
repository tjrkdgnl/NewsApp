package com.hugh.category.data.room

import com.hugh.category.domain.entity.ArticleEntity
import com.hugh.room.model.RoomArticle

internal fun ArticleEntity.toRoom(): RoomArticle {
    return RoomArticle(
        id = null,
        uid = this.uid,
        title = this.title,
        author = this.author,
        date = this.publishedAt,
        description = this.description,
        content = this.content,
        urlToImage = this.urlToImage,
        timestamp = this.timestamp
    )
}
