package com.android.example.skillsswapping

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    enum class AuthenticationState {
        UNAUTHENTICATED,        // Initial state, the user needs to authenticate
        AUTHENTICATED  ,        // The user has authenticated successfully
        INVALID_AUTHENTICATION  // Authentication failed
    }

    val authenticationState = MutableLiveData<AuthenticationState>()

    init {
        authenticationState.value = AuthenticationState.UNAUTHENTICATED
    }

    fun authenticate(username: String, password: String) {
        if (passwordIsValidForUsername(username, password)) {
            authenticationState.value = AuthenticationState.AUTHENTICATED
        } else {
            authenticationState.value = AuthenticationState.INVALID_AUTHENTICATION
        }
    }

    private fun passwordIsValidForUsername(username: String, password: String): Boolean {
        return true
    }
}