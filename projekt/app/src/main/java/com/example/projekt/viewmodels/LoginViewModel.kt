package com.example.projekt.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projekt.model.*
import com.example.projekt.repository.Repository



class LoginViewModel(val context: Context, val repository: Repository) : ViewModel() {
    var token = MutableLiveData<String>()
    var user = MutableLiveData<User>()

    init{
        user.value = User()
    }

    suspend fun login() {
        val request = LoginRequest(username = user.value!!.username, password = user.value!!.password)
        try {
            val result = repository.login(request)
            token.value = result.token
            Log.d("xxx", "MyApplication - token:  ${result.token}")
        } catch (e: Exception) {
            Log.d("xxx", "LoginViewModel - exception: ${e.toString()}")
        }
    }
}