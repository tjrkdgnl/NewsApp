package com.hugh.category.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hugh.category.data.room.ArticleDataBase.Companion.ROOM_VERSION
import com.hugh.category.data.room.model.RoomArticle

@Database(entities = [RoomArticle::class], version = ROOM_VERSION, exportSchema = false)
internal abstract class ArticleDataBase : RoomDatabase() {

    abstract fun articleDao(): ArticleDao

    companion object {
        const val ROOM_VERSION = 2
    }
}