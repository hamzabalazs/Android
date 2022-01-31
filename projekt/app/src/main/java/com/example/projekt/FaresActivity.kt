package com.example.projekt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class FaresActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fares)
    }

    fun goToTimeline(view: View){
        startActivity(Intent(this,TimeLineActivity::class.java))
    }

    fun goToSettings(view: View){
        startActivity(Intent(this,SettingsActivity::class.java))
    }

    fun goToMarket(view: View){
        startActivity(Intent(this,MarketActivity::class.java))
    }

    fun goBackToMain(view: View){
        startActivity(Intent(this,MainActivity::class.java))
    }
}