package com.hugh.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.hugh.room.model.RoomArticle
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Query("SELECT * FROM Article ORDER BY timestamp DESC")
    fun getArticleFlow(): Flow<List<RoomArticle>>

    @Query("SELECT * FROM article WHERE title = :title")
    suspend fun checkArticle(title: String): RoomArticle

    @Insert(onConflict = REPLACE)
    suspend fun insertArticle(article: RoomArticle)

    @Query("DELETE FROM Article WHERE title = :title")
    suspend fun deleteArticle(title: String)

}