package com.hugh.bookmark.data

import com.hugh.bookmark.domain.entity.ArticleEntity
import com.hugh.room.model.RoomArticle


fun RoomArticle.toEntity(): ArticleEntity {
    return ArticleEntity.EMPTY.copy(
        uid = this.uid,
        author = this.author,
        description = this.description,
        content = this.content,
        publishedAt = this.date,
        title = this.title,
        urlToImage = this.urlToImage,
        timestamp = this.timestamp
    )
}