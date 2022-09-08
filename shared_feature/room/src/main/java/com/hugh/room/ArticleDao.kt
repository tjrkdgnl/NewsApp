package com.hugh.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.hugh.room.model.RoomArticle
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Query("SELECT * FROM Article")
    fun getArticleFlow(): Flow<List<RoomArticle>>

    @Insert(onConflict = REPLACE)
    suspend fun insertArticle(article: RoomArticle)

    @Query("DELETE FROM Article WHERE uid = :uid")
    suspend fun deleteArticle(uid: String)

}