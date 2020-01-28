package com.android.example.skillsswapping

import android.app.Application
import android.content.Context
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

    private val PREFERENCE_MAIN = "PREFERENCE_MAIN"
    private val PREFERENCE_IS_LOGIN = "PREFERENCE_IS_LOGIN"

    val isLogin = MutableLiveData<Boolean>(application
        .getSharedPreferences(PREFERENCE_MAIN, Context.MODE_PRIVATE)
        .getBoolean(PREFERENCE_IS_LOGIN, false)
    )

    fun logout() {
        isLogin.value = false
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}