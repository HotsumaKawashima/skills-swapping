package com.android.example.skillsswapping

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.example.skillsswapping.database.getDatabase
import com.android.example.skillsswapping.repository.UserRepository

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val userRepository = UserRepository(getDatabase(application))

    val loginUser = userRepository.loginUser
}