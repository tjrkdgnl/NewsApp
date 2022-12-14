package com.hugh.bookmark.data

import com.hugh.entity.ArticleEntity
import com.hugh.room.model.RoomArticle


fun RoomArticle.toEntity(): ArticleEntity {
    return ArticleEntity.EMPTY.copy(
        author = this.author,
        description = this.description,
        content = this.content,
        publishedAt = this.date,
        title = this.title,
        urlToImage = this.urlToImage,
        timestamp = this.timestamp
    )
}