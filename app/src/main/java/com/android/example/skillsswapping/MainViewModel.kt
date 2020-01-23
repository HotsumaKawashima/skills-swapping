package com.android.example.skillsswapping

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.example.skillsswapping.domain.User

class MainViewModel : ViewModel() {

    val user = MutableLiveData<User>()
}