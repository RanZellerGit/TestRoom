package com.example.roomtest

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
abstract class ArticlesDao {

    @Query("SELECT * FROM articleTableName")
    abstract suspend fun getArticle(): List<Article>

    @Query("DELETE FROM articleTableName")
    abstract fun clearArticles()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertArticle(article: Article)

}