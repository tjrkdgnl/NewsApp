package com.hugh.room

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideRoom(
        @ApplicationContext context: Context
    ): ArticleDataBase {
        return Room.databaseBuilder(
            context,
            ArticleDataBase::class.java,
            "articleRoom"
        ).addMigrations(object :
            Migration(ArticleDataBase.ROOM_VERSION - 1, ArticleDataBase.ROOM_VERSION) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    "CREATE TABLE Article_backup " +
                            "(" +
                                "author TEXT NOT NULL , " +
                                "content TEXT NOT NULL, " +
                                "description TEXT NOT NULL," +
                                " date TEXT NOT NULL," +
                                " title TEXT NOT NULL, " +
                                "urlToImage TEXT NOT NULL, " +
                                "timestamp INTEGER NOT NULL," +
                                " id INTEGER PRIMARY KEY AUTOINCREMENT" +
                            ")"
                )
                database.execSQL("INSERT INTO Article_backup SELECT author,content,description,date,title,urlToImage,timestamp,id FROM Article")
                database.execSQL("DROP TABLE Article")
                database.execSQL("ALTER TABLE Article_backup RENAME to Article")
            }
        }).build()
    }
}