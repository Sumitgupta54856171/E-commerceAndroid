package com.example.e_commerce.api

import com.example.e_commerce.model.Loginuser
import com.example.e_commerce.model.User
import com.example.e_commerce.model.logindata
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {

    @POST("/api/users/register")
     fun registerUser(@Body user: User): Call<User>

    @POST("/api/users/login")
     fun loginUser(@Body user : Loginuser ) : Call<String>

    @POST("/api/users/auth")
     fun auth(@Body token : String) : Call<Boolean>
}
