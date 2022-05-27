package com.example.projekt
import com.example.projekt.RetrofitInstance
import retrofit2.Response

class Repository {
    suspend fun login(request: LoginRequest) : LoginResponse {
        return RetrofitInstance.api.login(request)
    }

    suspend fun register(request: RegisterRequest) : RegisterResponse {
        return RetrofitInstance.api.register(request)
    }

    suspend fun getProducts(token: String, limit : Int) : ProductResponse {
        return RetrofitInstance.api.getProducts(token, limit)
    }

    suspend fun getOrders(token : String, limit: Int) : OrderResponse {
        return RetrofitInstance.api.getOrders(token, limit)
    }
}