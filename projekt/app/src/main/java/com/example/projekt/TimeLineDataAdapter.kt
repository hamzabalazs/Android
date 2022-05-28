package com.example.projekt

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TimelineDataAdapter(private val username: String ,private val productList: List<Product>) : RecyclerView.Adapter<TimelineDataAdapter.DataViewHolder>() {

    var  createCounter: Int = 0
    var bindCounter: Int = 0





    inner class DataViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val ownerTV: TextView = itemView.findViewById(R.id.timelineItemOwnerTV)
        val titleTV: TextView = itemView.findViewById(R.id.timelineItemTitleTV)
        val priceTV: TextView = itemView.findViewById(R.id.timelineItemPriceTV)
        val availabilityTV: TextView = itemView.findViewById(R.id.timelineAvailabilityTV)


    }

    override fun getItemCount() = productList.size



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        ++createCounter
        Log.d("xxx", "onCreateViewHolder: $createCounter")
        return DataViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val currentItem = productList[position]
        holder.ownerTV.text = currentItem.username
        holder.priceTV.text = "${currentItem.price_per_unit} ${currentItem.price_type}"
        holder.titleTV.text = currentItem.title


        if (currentItem.is_active) {
            holder.availabilityTV.text = "available"
        }
        else{
            holder.availabilityTV.text = "unavailable"

        }
        ++bindCounter
        Log.d("xxx", "onBindViewHolder: $bindCounter")
    }
}