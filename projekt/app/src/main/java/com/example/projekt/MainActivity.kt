package com.example.projekt

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var timelineViewModel: TimelineViewModel
    private lateinit var list : List<Product>
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter : TimelineDataAdapter
    private lateinit var username : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getPreferences(Context.MODE_PRIVATE)

        val factory = TimelineViewModelFactory(Repository(), sharedPref!!)
        timelineViewModel = ViewModelProvider(this,factory).get(TimelineViewModel::class.java)

        recyclerView = findViewById(R.id.recycler_view_main)
        setupRecyclerView()

    }



    private fun setupRecyclerView(){
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        username = sharedPref?.getString(getString(R.string.username_sharedpreferences_string_resource), "").toString()
        adapter = TimelineDataAdapter(username,list)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
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

    fun goToFares(view: View){
        startActivity(Intent(this,FaresActivity::class.java))
    }



}