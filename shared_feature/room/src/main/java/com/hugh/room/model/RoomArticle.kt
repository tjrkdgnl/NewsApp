package com.hugh.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Article")
data class RoomArticle(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int?,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "author") val author: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "urlToImage") val urlToImage: String,
    @ColumnInfo(name = "timestamp") val timestamp: Long,

)