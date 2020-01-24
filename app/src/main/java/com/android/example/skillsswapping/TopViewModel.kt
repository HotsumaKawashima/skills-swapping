package com.android.example.skillsswapping

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TopViewModel(category: String) : ViewModel() {

    @Suppress("UNCHECKED_CAST")
    class Factory(private val category: String) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(TopViewModel::class.java)) {
                return TopViewModel(category) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }

    fun goToCategory(category: String): Bundle {
        return bundleOf("category" to category)
    }
}