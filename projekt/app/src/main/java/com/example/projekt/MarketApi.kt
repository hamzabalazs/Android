package com.example.projekt

import retrofit2.Response
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
interface MarketApi {

    @POST("/user/register")
    suspend fun register(@Body request: RegisterRequest): Response<RegisterResponse>

    @POST("/user/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @GET("/products")
    suspend fun getProducts(@Header("token") token: String, @Header("skip") skip: Int, @Header("filter") filter: String): Response<ProductResponse>
}