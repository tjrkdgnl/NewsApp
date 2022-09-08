package com.hugh.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hugh.room.ArticleDataBase.Companion.ROOM_VERSION
import com.hugh.room.model.RoomArticle

@Database(entities = [RoomArticle::class], version = ROOM_VERSION, exportSchema = false)
abstract class ArticleDataBase : RoomDatabase() {

    abstract fun articleDao(): ArticleDao

    companion object {
        const val ROOM_VERSION = 2
    }
}