package com.hugh.category.domain.entity

import java.io.Serializable


data class ArticleEntity(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val title: String,
    val urlToImage: String
) : Serializable