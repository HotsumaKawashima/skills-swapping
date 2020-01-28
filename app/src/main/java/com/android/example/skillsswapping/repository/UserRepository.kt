package com.android.example.skillsswapping.repository

import com.android.example.skillsswapping.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(private val database: AppDatabase) {

    suspend fun authenticate(userName: String, userPassword: String) : Boolean {
        val user = withContext(Dispatchers.IO) {
            database.userDao().getUserByName(userName, userPassword)
        }

        if(user != null) {
            return true
        }
        return false
    }
}