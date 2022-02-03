package com.example.projekt
import com.example.projekt.RetrofitInstance
import com.example.projekt.LoginRequest
import com.example.projekt.LoginResponse
import com.example.projekt.ProductResponse
import retrofit2.Response

class Repository {
    suspend fun login(request: LoginRequest): Response<LoginResponse> {
        return RetrofitInstance.api.login(request)
    }

    suspend fun getProducts(token: String): Response<ProductResponse> {
        return RetrofitInstance.api.getProducts(token,0,"")
    }
}