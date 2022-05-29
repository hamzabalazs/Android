package com.example.projekt.repository


import com.example.projekt.api.RetrofitInstance
import com.example.projekt.model.*
import retrofit2.Response

class Repository {
    suspend fun login(request: LoginRequest) : LoginResponse {
        return RetrofitInstance.api.login(request)
    }

    suspend fun resetPassword(request: ResetPasswordRequest) : ResetPasswordResponse {
        return RetrofitInstance.api.resetPassword(request)
    }

    suspend fun register(request: RegisterRequest) : RegisterResponse {
        return RetrofitInstance.api.register(request)
    }

    suspend fun getProducts(token: String, limit : Int) : ProductResponse {
        return RetrofitInstance.api.getProducts(token, limit)
    }
    suspend fun getProductsFilteredByTitle(token:String, filter:String) : ProductResponse {



        return RetrofitInstance.api.getProductsFilteredByTitle(token, filter)
    }

    suspend fun addProduct(token: String,title : String, description : String,price_per_unit : String,units : String, is_active : Boolean,rating : Double,amount_type : String, price_type : String) : AddProductResponse
    {
        return RetrofitInstance.api.addProduct(token,title, description,price_per_unit ,units , is_active ,rating ,amount_type , price_type )
    }


    suspend fun removeProduct(token: String, product_id : String): DeleteProductResponse {
        return RetrofitInstance.api.removeProduct(token, product_id)
    }



    suspend fun addOrder(token: String,title : String, description : String,price_per_unit : String,units : String, owner_username : String, revolut_link : String){
        //return RetrofitInstance.api.addOrder(token,title, description, price_per_unit, units, owner_username, revolut_link)
        return RetrofitInstance.api.addOrder(token,title, description, price_per_unit, units, owner_username)
    }

    suspend fun getOrders(token : String, limit: Int) : OrderResponse {
        return RetrofitInstance.api.getOrders(token, limit)
    }

    suspend fun updateUser(token : String, username: String,email : String, phone_number: String) : UpdateUserResponse{
        return RetrofitInstance.api.updateUser(token, email, phone_number, username)
    }

    suspend fun updateOrder(order_id: String, token: String, request: OrderUpdateRequest) : OrderUpdateResponse{
        return RetrofitInstance.api.updateOrder(order_id,token, request)
    }

}