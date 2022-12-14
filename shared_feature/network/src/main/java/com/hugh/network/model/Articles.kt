package com.hugh.network.model

import kotlinx.serialization.Serializable

@Serializable
data class Articles(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)