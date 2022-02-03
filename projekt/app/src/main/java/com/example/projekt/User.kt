package com.example.projekt

import com.google.gson.annotations.SerializedName

data class User(
    var username: String="",
    var password: String="",
    val email: String="",
    var phone_number: String=""
)

data class LoginRequest(
    @SerializedName("username")
    var username: String,

    @SerializedName("password")
    var password: String
)

data class LoginResponse(
    @SerializedName("username")
    var username: String,

    @SerializedName("email")
    var email: String,

    @SerializedName("phone_number")
    var phone_number: Int,

    @SerializedName("token")
    var token: String,

    @SerializedName("creation_time")
    var creation_time: Long,

    @SerializedName("refresh_time")
    var refresh_time: Long
)

data class RegisterRequest(
    @SerializedName("username")
    var username: String,

    @SerializedName("email")
    var email: String,

    @SerializedName("phone_number")
    var phone_number: String,

    @SerializedName("password")
    var password: String
)

data class RegisterResponse(
    @SerializedName("creation_time")
    var creation_time: Long
)

