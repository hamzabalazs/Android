package com.example.projekt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ForgotPassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pass)

        val forgotEmail = findViewById<EditText>(R.id.editTextForgotEmail)
        val forgotButton = findViewById<Button>(R.id.forgotPassButton)
    }
}