package com.example.projekt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch


class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val editUsername = findViewById<EditText>(R.id.editUsername)
        val editEmail = findViewById<EditText>(R.id.editTextRegEmail)
        val editPassword = findViewById<EditText>(R.id.editTextRegPassword)
        val editPhoneNumber = findViewById<EditText>(R.id.editPhoneNum)
        val registerbutton = findViewById<Button>(R.id.RegButton)

        registerbutton.setOnClickListener {
            var isValid = true
            if (editUsername.text.toString().trim().isEmpty()){
                isValid = false
                editUsername.setError("Username required")
            }
            if (editPassword.text.toString().trim().isEmpty()){
                isValid = false
                editPassword.setError("Password required")
            }
            if (editPhoneNumber.text.toString().trim().isEmpty()){
                isValid = false
                editPhoneNumber.setError("phone required")
            }
            if (editEmail.text.toString().trim().isEmpty()){
                isValid = false
                editEmail.setError("email required")
            }
            if(isValid){
                lifecycleScope.launch() {
                    register()

                }
                startActivity(Intent(this,LoginActivity::class.java));

            }
        }

    }
    suspend fun register() {
        val repository = Repository()
        val editUsername = findViewById<EditText>(R.id.editUsername)
        val editEmail = findViewById<EditText>(R.id.editTextRegEmail)
        val editPassword = findViewById<EditText>(R.id.editTextRegPassword)
        val editPhoneNumber = findViewById<EditText>(R.id.editPhoneNum)
        val request = RegisterRequest(username = editUsername.text.toString(), password = editPassword.text.toString(), email = editEmail.text.toString(), phone_number = editPhoneNumber.text.toString())
        try {

            val result = repository.register(request)


        } catch (e: Exception) {
            Log.d("xxx", "Register - exception: ${e.toString()}")
        }
    }



    fun goToLogin(view : View){
        startActivity(Intent(this,LoginActivity::class.java))
    }
}