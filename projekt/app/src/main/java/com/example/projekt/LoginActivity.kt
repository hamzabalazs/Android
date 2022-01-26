package com.example.projekt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editEmail = findViewById<EditText>(R.id.editTextEmail)
        val editPassword = findViewById<EditText>(R.id.editTextPassword)
        val logButton = findViewById<Button>(R.id.loginButton)
        val regButton = findViewById<Button>(R.id.registerButton)
        regButton.setOnClickListener{
            startActivity(Intent(this,RegisterActivity::class.java))
        }
        logButton.setOnClickListener {
            emailPasswordValidity(editEmail,editPassword)

        }

    }

    fun goToForgotPassword(view: View){
        startActivity(Intent(this,ForgotPassActivity::class.java));
    }
    fun emailPasswordValidity(email : EditText, password: EditText){
        val emailstring = email.text.toString();
        if (email.text.isNullOrBlank()){
            email.error = "Email is empty!"
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(emailstring).matches()){
            email.error = "Email format is wrong!"

        }
        if(password.length() < 8){
            password.error = "Password has to be 8 characters or more!"
        }
        if(password.text.isNullOrEmpty()){
            password.error = "Password is empty!"
        }

        if(!email.text.isNullOrEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(emailstring).matches() && password.length() >= 8){
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}