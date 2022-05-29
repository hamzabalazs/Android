package com.example.projekt.viewmodels

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projekt.model.Order
import com.example.projekt.repository.Repository
import kotlinx.coroutines.launch
import java.io.IOException

class OrdersViewModel(private val repository: Repository, private val sharedPreferences: SharedPreferences) : ViewModel() {
    var orders : MutableLiveData<List<Order>> = MutableLiveData()
    var currentOrder = Order("", "", "", "", "","", "", "", listOf(), 0, listOf())
    var token : String = ""
    var username : String = ""
    init{
        getOrders()
    }

    fun refreshOrders(){
        getOrders()
    }

    private fun getOrders() {
        viewModelScope.launch {
            //the request for all the orders is made because with the addition of useless characters: " \, the backend's filter is unusable
            //its much slower
            try {
                val token = sharedPreferences?.getString("token", "").toString()
                val result = repository.getOrders(token, 512)
                orders.value = result.orders
                Log.d("xxx", "OrderListViewModel - #products:  ${result.item_count}")
            }catch(e: IOException){
                Log.d("xxx", "OrderListViewModel exception: ${e.toString()}")
            }
        }
    }

}