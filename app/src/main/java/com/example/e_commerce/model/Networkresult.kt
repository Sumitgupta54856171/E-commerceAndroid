package com.example.e_commerce.model

sealed class Networkresult<T>(
    val data : T? = null,
    val message : String? = null
){
    class Success<T>(data: T) : Networkresult<T>(data)
    class Error<T>(message: String) : Networkresult<T>(message=message)
    class Loading<T> : Networkresult<T>()
}