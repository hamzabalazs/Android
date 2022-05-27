package com.example.projekt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var logButton: Button
    private lateinit var regButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val factory = LoginViewModelFactory(this, Repository())
        loginViewModel = ViewModelProvider(this, factory).get(LoginViewModel::class.java)

        username = findViewById(R.id.editTextUsername)
        password = findViewById(R.id.editTextPassword)
        logButton = findViewById(R.id.loginButton)
        regButton = findViewById(R.id.registerButton)

        logButton.setOnClickListener {
            var isValid = true
            if (username.text.toString().trim().isEmpty()){
                isValid = false
                username.setError("Username required")
            }
            if (password.text.toString().trim().isEmpty()){
                isValid = false
                password.setError("Password required")
            }
            //only start the login process if the fields are not empty
            if (isValid) {
                loginProcess(username.text.toString(),password.text.toString())
                startActivity(Intent(this,MainActivity::class.java))
            }
        }


    }


    private fun loginProcess(username : String, password : String){
        loginViewModel.user.value.let {
            if (it != null) {
                it.username = username
                it.password = password
            }
        }

        lifecycleScope.launch {
            loginViewModel.login()

        }
        //startActivity(Intent(this,MainActivity::class.java))

    }

    fun goToRegister(view : View){
        startActivity(Intent(this,RegisterActivity::class.java))
    }




}