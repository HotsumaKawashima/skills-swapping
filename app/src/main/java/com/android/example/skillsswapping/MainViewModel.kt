package com.android.example.skillsswapping

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.*
import androidx.room.Room
import com.android.example.skillsswapping.database.AppDatabase
import kotlinx.coroutines.*

class MainViewModel(private val application: Application, handle: SavedStateHandle) : ViewModel() {

    class Factory(val app: MainActivity)
        : AbstractSavedStateViewModelFactory(app, null) {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(
            key: String,
            modelClass: Class<T>,
            handle: SavedStateHandle
        ): T {
            return MainViewModel(app.application, handle) as T
        }
    }

    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    val isLogin = handle.getLiveData<Boolean>("isLogin").apply { value ?: false }
    private val userName = handle.getLiveData<String>("userName")
    private val userPassword = handle.getLiveData<String>("userPassword")

    init {
        viewModelScope.launch {
            load()
        }
    }

    fun loginWithUserName(userName: String, userPassword: String) {
        this.userName.value = userName
        this.userPassword.value = userPassword
        isLogin.value = true
    }

    fun logout() {
        userName.value = null
        userPassword.value = null
        isLogin.value = false
    }

    suspend fun load() {
        withContext(Dispatchers.IO) {
            val db = Room.databaseBuilder(
                application,
                AppDatabase::class.java, "t2"
            )
                .createFromAsset("default.db")
                .build()

            println(db.userDao().getAllUser())
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}