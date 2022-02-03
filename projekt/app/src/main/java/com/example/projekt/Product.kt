package com.example.projekt

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("_id")
    val _id: String,

    @SerializedName("image_id")
    val image_id: String,

    @SerializedName("image_name")
    val image_name: String,

    @SerializedName("image_path")
    val image_path: String
)


data class Product(
    @SerializedName("rating")
    val rating: Double,

    @SerializedName("amount_type")
    val amount_type: String,

    @SerializedName("price_type")
    val price_type: String,

    @SerializedName("product_id")
    val product_id: String,

    @SerializedName("username")
    val username: String,

    @SerializedName("is_active")
    val is_active: Boolean,

    @SerializedName("price_per_unit")
    val price_per_unit: String,

    @SerializedName("units")
    val units: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("images")
    val images: List<Image>,

    @SerializedName("creation_time")
    val creation_time: Long
)



data class ProductResponse(
    @SerializedName("item_count")
    val item_count: Int,

    @SerializedName("products")
    val products: List<Product>,

    @SerializedName("timestamp")
    val timestamp: Long
)