package com.android.example.skillsswapping

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.android.example.skillsswapping.database.AppDatabase
import com.android.example.skillsswapping.database.UserDao
import com.android.example.skillsswapping.util.LiveDataTestUtil.getValue
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppDatabaseTest {

    private lateinit var userDao: UserDao
    private lateinit var appDatabase: AppDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext

        appDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "data")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        userDao = appDatabase.userDao()
    }

    @After
    fun closeDb() {
        appDatabase.close()
    }

    @Test
    fun getUser() {
        val user = getValue(userDao.getUser())
        assertEquals(user.name, "name")
        assertEquals(user.password, "password")
    }
}