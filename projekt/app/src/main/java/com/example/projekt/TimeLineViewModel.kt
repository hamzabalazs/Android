package com.example.projekt

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Exception

class TimelineViewModel(private val repository: Repository, private val sharedPreferences: SharedPreferences) : ViewModel() {
    var products : MutableLiveData<List<Product>> = MutableLiveData()
    var currentProduct = Product(0.0, "", "", "", "",false, "", "", "", "", listOf(), 0, listOf())
    var token : String = ""
    init {

        getProducts()
    }


    fun refreshProducts(){
        getProducts()
    }

    private fun getProducts() {

        viewModelScope.launch{
            try {
                val token = sharedPreferences?.getString("token", "").toString()
                val result = repository.getProducts(token , 10)
                products.value = result.products
                Log.d("xxx", "ListViewModel - #products:  ${result.item_count}")

            }catch (e: Exception) {
                Log.d("xxx", "TimeLineViewModel exception: ${e.toString()}")

            }
        }
    }
}
