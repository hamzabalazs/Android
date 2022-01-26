package com.example.projekt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val editFullName = findViewById<EditText>(R.id.editTextFullName)
        val editLastName = findViewById<EditText>(R.id.editTextLastName)
        val editEmail = findViewById<EditText>(R.id.editTextRegEmail)
        val editPassword = findViewById<EditText>(R.id.editTextRegPassword)
        val registerbutton = findViewById<Button>(R.id.RegButton)

        registerbutton.setOnClickListener {
            informationValidity(editFullName,editLastName,editEmail,editPassword)
        }

    }

    fun informationValidity(fullName : EditText, lastName : EditText,email : EditText, password: EditText){
        val emailstring = email.text.toString()


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

        if(fullName.text.isNullOrEmpty()){
            fullName.error = "Full Name is empty!"
        }
        if(lastName.text.isNullOrEmpty()){
            lastName.error = "Last Name is empty!"
        }

        if(!email.text.isNullOrEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(emailstring).matches() && password.length() >= 8 && !fullName.text.isNullOrEmpty() && !lastName.text.isNullOrEmpty()){

            startActivity(Intent(this,MainActivity::class.java))
        }
    }

    fun goToLogin(view : View){
        startActivity(Intent(this,LoginActivity::class.java))
    }
}