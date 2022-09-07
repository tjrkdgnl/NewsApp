package com.hugh.category.domain.entity

import java.io.Serializable


data class ArticleEntity(
    val uid: String,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val title: String,
    val urlToImage: String
) : Serializable {

    companion object {
        val EMPTY = ArticleEntity(
            uid = "-1",
            author = "",
            content = "내용이 존재하지 않습니다.",
            description = "내용이 존재하지 않습니다.",
            publishedAt = "",
            title = "",
            urlToImage = ""
        )
    }
}