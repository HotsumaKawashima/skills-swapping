package com.android.example.skillsswapping.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface ServiceDao {

    @Query("SELECT * FROM service")
    fun getService(): LiveData<List<Service>>
}