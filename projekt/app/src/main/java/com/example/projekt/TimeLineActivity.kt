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

    private lateinit var binding: ActivityTimeLineBinding

    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTimeLineBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_time_line)
        setupRecyclerView()

        lifecycleScope.launchWhenCreated {
            val response = try{
                RetrofitInstance.api.getProducts(MyApplication.token,0,"")

            } catch(e: IOException){
                Log.e(TAG, "IOException")
                return@launchWhenCreated
            } catch(e: HttpException){
                Log.e(TAG,"HttpException")
                return@launchWhenCreated
            }

        }
    }

    private fun setupRecyclerView() = binding.recyclerViewProductsTimeline.apply{
        productAdapter = ProductAdapter()
        adapter = productAdapter
        layoutManager = LinearLayoutManager(this@TimeLineActivity)

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