package com.example.roomtest

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.coroutines.runBlocking
import org.hamcrest.Matchers
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RoomTest{

    private lateinit var dao : ArticlesDao
    private lateinit var db : ArticlesDatabase

    @Before
    fun createDb(){
        db = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().context, ArticlesDatabase::class.java).build()
        dao = db.getDao()
    }

    private val article1 = Article(1,"blblba")
    private val article2 = Article(2,"blblba1")
    @Test
    fun testArticle() = runBlocking{
        dao.insertArticle(article1)
        dao.insertArticle(article2)

        val local = dao.getArticle()
        Assert.assertThat(local.size, Matchers.equalTo(2) )
    }

    @After
    fun closeBb(){
        db.close()
    }

}