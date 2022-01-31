package com.example.projekt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
    }

    val settingsEmail = findViewById<EditText>(R.id.editTextSettingsEmail)
    val settingsUsername = findViewById<EditText>(R.id.editTextSettingsUsername)
    val settingsPhonenumber = findViewById<EditText>(R.id.editTextSettingsPhonenumber)
    val settingsPassword = findViewById<EditText>(R.id.editTextSettingsPassword)
    val settingsButton = findViewById<Button>(R.id.PublishSettingsButton)

    fun goToTimeline(view: View){
        startActivity(Intent(this,TimeLineActivity::class.java))
    }

    fun goBackToMain(view: View){
        startActivity(Intent(this,MainActivity::class.java))
    }

    fun goToMarket(view: View){
        startActivity(Intent(this,MarketActivity::class.java))
    }

    fun goToFares(view: View){
        startActivity(Intent(this,FaresActivity::class.java))
    }
    fun settingsValidation(email: EditText, username: EditText, phonenumber: EditText, password: EditText){
        val emailstring = email.text.toString()
        var isError = false
        if (email.text.isNullOrEmpty()){
            email.error = "Email is empty!"
            isError = true
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(emailstring).matches()){
            email.error = "Email format is wrong!"
            isError = true

        }
        if(password.length() < 8){
            password.error = "Password has to be 8 characters or more!"
            isError = true
        }
        if(password.text.isNullOrEmpty()){
            password.error = "Password is empty!"
            isError = true
        }

        if(username.text.isNullOrEmpty()){
            username.error = "Username is empty!"
            isError = true
        }

        if(phonenumber.length() != 10){
            phonenumber.error = "Incorrect Phonenumber! Phonenumber must be 10 digits!"
            isError = true
        }

        if(phonenumber.text.isNullOrEmpty()){
            phonenumber.error = "PhoneNumber is empty!"
            isError = true
        }

        if(!isError){
            startActivity(Intent(this,MainActivity::class.java))
        }
    }

}