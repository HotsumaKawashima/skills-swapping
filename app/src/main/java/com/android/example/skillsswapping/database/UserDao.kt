package com.android.example.skillsswapping.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.android.example.skillsswapping.database.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user LIMIT 1")
    fun getUser(): LiveData<User>

    @Query("SELECT * FROM user WHERE user_id = :id LIMIT 1")
    fun getUserById(id: Int): User

    @Query("SELECT * FROM user WHERE name = :userName AND password = :userPassword LIMIT 1")
    fun getUserByName(userName: String, userPassword: String): User

    @Query("SELECT * FROM user")
    fun getAllUser(): List<User>

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)
}