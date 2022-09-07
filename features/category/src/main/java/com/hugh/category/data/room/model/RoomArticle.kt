package com.hugh.category.data.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Article")
data class RoomArticle(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int?,
    @ColumnInfo(name = "uid") val uid: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "author") val author: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "urlToImage") val urlToImage: String
)