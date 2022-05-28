package com.example.projekt

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TimelineViewModelFactory(private val repository: Repository, private val sharedPref : SharedPreferences) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TimelineViewModel(repository, sharedPref) as T
    }
}