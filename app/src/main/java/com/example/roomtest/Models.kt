package com.example.roomtest

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articleTableName")
class Article(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id : Int? = null,

    @ColumnInfo(name = "textBody")
    val textBody : String

)