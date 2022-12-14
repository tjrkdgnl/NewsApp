package com.hugh.entity

import java.io.Serializable
import java.time.Instant


data class ArticleEntity(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val title: String,
    val urlToImage: String,
    val timestamp: Long
) : Serializable {

    companion object {
        val EMPTY = ArticleEntity(
            author = "",
            content = "내용이 존재하지 않습니다.",
            description = "내용이 존재하지 않습니다.",
            publishedAt = "",
            title = "",
            urlToImage = "",
            timestamp = Instant.EPOCH.toEpochMilli()
        )
    }
}