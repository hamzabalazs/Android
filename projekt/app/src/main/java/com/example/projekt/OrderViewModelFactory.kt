package com.example.projekt

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class OrdersViewModelFactory(private val repository: Repository, private val sharedPreferences: SharedPreferences) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return OrdersViewModel(repository, sharedPreferences) as T
    }
}