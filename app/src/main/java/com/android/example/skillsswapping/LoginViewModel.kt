package com.android.example.skillsswapping

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.android.example.skillsswapping.database.getDatabase
import com.android.example.skillsswapping.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class LoginViewModel(application: Application, handle: SavedStateHandle) : ViewModel() {

    class Factory(val app: FragmentActivity)
        : AbstractSavedStateViewModelFactory(app, null) {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(
            key: String,
            modelClass: Class<T>,
            handle: SavedStateHandle
        ): T {
            return LoginViewModel(app.application, handle) as T
        }
    }

    enum class AuthenticationState {
        UNAUTHENTICATED,        // Initial state, the user needs to authenticate
        AUTHENTICATED  ,        // The user has authenticated successfully
        INVALID_AUTHENTICATION  // Authentication failed
    }

    private val userRepository = UserRepository(getDatabase(application))

    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    val authenticationState = MutableLiveData<AuthenticationState>(AuthenticationState.UNAUTHENTICATED)
    val userName = MutableLiveData<String>("name")
    val userPassword = MutableLiveData<String>("password")

    fun authenticate() {
        viewModelScope.launch {
            val userName = userName.value
            val userPassword = userPassword.value

            if(userName == null || userPassword == null) {
                authenticationState.value = AuthenticationState.INVALID_AUTHENTICATION
            } else if(userRepository.authenticate(userName, userPassword)) {
                authenticationState.value = AuthenticationState.AUTHENTICATED
            } else {
                authenticationState.value = AuthenticationState.INVALID_AUTHENTICATION
            }
        }
    }
}