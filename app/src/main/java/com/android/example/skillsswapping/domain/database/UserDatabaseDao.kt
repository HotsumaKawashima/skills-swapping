package com.android.example.skillsswapping.domain.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.android.example.skillsswapping.domain.User

@Dao
interface UserDatabaseDao {

    @Insert
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Query("SELECT * from users_table WHERE userid = :key")
    fun get(key: Long): User?

    @Query("SELECT * FROM users_table WHERE user_name")
    fun findByName(first: String, last: String): User
}