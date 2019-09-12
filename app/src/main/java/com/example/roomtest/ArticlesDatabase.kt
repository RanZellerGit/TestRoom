package com.example.roomtest

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Article::class], version = 1)
abstract class  ArticlesDatabase : RoomDatabase(){

    abstract fun getDao() : ArticlesDao
}