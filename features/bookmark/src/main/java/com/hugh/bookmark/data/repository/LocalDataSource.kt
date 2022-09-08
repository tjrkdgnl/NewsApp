package com.hugh.bookmark.data.repository

import com.hugh.room.ArticleDataBase
import com.hugh.room.model.RoomArticle
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val articleDataBase: ArticleDataBase
) {


     fun getArticles(): Flow<List<RoomArticle>> {
        return articleDataBase.articleDao().getArticleFlow()
    }
}