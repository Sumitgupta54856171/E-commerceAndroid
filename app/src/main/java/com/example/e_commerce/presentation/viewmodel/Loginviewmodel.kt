package com.example.e_commerce.presentation.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerce.api.Api
import com.example.e_commerce.model.Loginuser

import com.example.e_commerce.model.User
import com.example.e_commerce.utils.SecureTokenManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

@HiltViewModel
class Loginviewmodel @Inject constructor(application: Application,private val api: Api) : AndroidViewModel(application) {
    var email by mutableStateOf("")
        private set
    var username by mutableStateOf("")
        private set



    var password by mutableStateOf("")
        private set

    var auth by mutableStateOf(false)

    val authdata: StateFlow<Boolean> = snapshotFlow { auth }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), auth)

    fun onEmailchange(value: String) {
        email = value
    }

    fun onPasswordchange(value: String) {
        password = value
    }
    fun onUsernamechange(value: String) {
        username = value
    }

    fun onregister(username: String, email: String, password: String) {

        val call = api.registerUser(User(username, email, password))
        call.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful){
                    Toast.makeText(getApplication(),"Registration successful",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(getApplication(),"Registration failed",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
               Toast.makeText(getApplication(),"please try agian",Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun onlogin(password: String, email: String) {
        val call = api.loginUser(Loginuser(email, password))
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    val token = response.body()
                    if (token != null) {
                        SecureTokenManager(getApplication()).saveToken(token)

                    }else{
                        Toast.makeText(getApplication(), "Login failed", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(getApplication(), "Login failed", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Toast.makeText(getApplication(), "Login failed", Toast.LENGTH_SHORT).show()

            }
        })
    }


    fun onauth(value: String) {
        val call = api.auth(value)
        call.enqueue(object : Callback<Boolean> {
            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                if (response.isSuccessful) {
                    auth = response.body() ?: false
                }
            }

            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                auth = false
            }
        })
    }
}
