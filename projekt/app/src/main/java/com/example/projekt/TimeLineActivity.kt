package com.example.projekt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TimeLineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_line)
    }

    fun goToSettings(view: View){
        startActivity(Intent(this,SettingsActivity::class.java))
    }

    fun goToMarket(view: View){
        startActivity(Intent(this,MarketActivity::class.java))
    }

    fun goToFares(view: View){
        startActivity(Intent(this,FaresActivity::class.java))
    }
}