package com.android.example.skillsswapping

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.android.example.skillsswapping.database.Service
import com.android.example.skillsswapping.database.getDatabase
import com.android.example.skillsswapping.repository.ServiceRepository


class MyPostsViewModel(application: Application): AndroidViewModel(application){

    private val serviceRepository = ServiceRepository(getDatabase(application))

    var postedServices = serviceRepository.getPostedServices()

    fun getPosts(): LiveData<List<Service>> {
        return postedServices
    }

}