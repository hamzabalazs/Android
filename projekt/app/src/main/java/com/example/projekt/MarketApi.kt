package com.example.projekt

import retrofit2.Response
import com.example.projekt.Constants
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
interface MarketApi {

    @POST(Constants.REGISTER_URL)
    suspend fun register(@Body request: RegisterRequest) : RegisterResponse

    @POST(Constants.LOGIN_URL)
    suspend fun login(@Body request: LoginRequest) : LoginResponse

    @GET(Constants.GET_PRODUCTS_URL)
    suspend fun getProducts(@Header ("token") token: String, @Header ("limit") limit : Int) : ProductResponse

    @GET(Constants.GET_ORDERS_URL)
    suspend fun getOrders(@Header ("token") token: String, @Header ("limit") limit : Int) : OrderResponse
}