package com.example.projekt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
    }

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
}