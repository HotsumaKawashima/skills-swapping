package com.android.example.skillsswapping.repository

import androidx.lifecycle.LiveData
import com.android.example.skillsswapping.database.AppDatabase
import com.android.example.skillsswapping.database.Service

class ServiceRepository(private val database: AppDatabase){
    //val postedServices = database.serviceDao().getService()

    fun getPostedServices(): LiveData<List<Service>> {
        return database.serviceDao().getService()
    }
}