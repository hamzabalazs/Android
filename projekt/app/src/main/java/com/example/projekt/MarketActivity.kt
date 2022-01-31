package com.example.projekt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MarketActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_market)
    }

    fun goToSettings(view: View){
        startActivity(Intent(this,SettingsActivity::class.java))
    }

    fun goToTimeline(view: View){
        startActivity(Intent(this,TimeLineActivity::class.java))
    }

    fun goToFares(view: View){
        startActivity(Intent(this,FaresActivity::class.java))
    }

    fun goBackToMain(view: View){
        startActivity(Intent(this,MainActivity::class.java))
    }
}