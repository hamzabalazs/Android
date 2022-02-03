package com.example.projekt

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api: MarketApi by lazy{
        Retrofit.Builder()
            .baseUrl("https://pure-gorge-51703.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MarketApi::class.java)
    }

}