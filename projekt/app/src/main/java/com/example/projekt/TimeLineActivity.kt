package com.example.projekt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projekt.databinding.ActivityTimeLineBinding
import retrofit2.HttpException
import java.io.IOException

const val TAG = "TimeLineActivity"

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