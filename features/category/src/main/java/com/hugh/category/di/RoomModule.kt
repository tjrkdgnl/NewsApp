package com.hugh.category.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.hugh.category.data.room.ArticleDataBase
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
                database.execSQL("ALTER TABLE Article ADD COLUMN uid TEXT NOT NULL DEFAULT '-1'")
            }
        }).build()
    }

}