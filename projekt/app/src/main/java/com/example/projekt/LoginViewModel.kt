package com.example.projekt

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch



class LoginViewModel(val context: Context, val repository: Repository) : ViewModel() {
    var token: MutableLiveData<String> = MutableLiveData()
    var user = MutableLiveData<User>()

    init {
        user.value = User()
    }

    fun login() {
        viewModelScope.launch {
            val request =
                LoginRequest(username = user.value!!.username, password = user.value!!.password)
            try {
                val result = repository.login(request)
                MyApplication.token = result.body()!!.token
                token.value = result.body()!!.token
                Log.d("xxx", "MyApplication - token:  ${MyApplication.token}")
            } catch (e: Exception) {
                Log.d("xxx", "MainViewModel - exception: ${e.toString()}")
            }
        }
    }
}