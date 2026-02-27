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
import com.example.e_commerce.model.Networkresult
import com.example.e_commerce.model.User
import com.example.e_commerce.utils.SecureTokenManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject



@HiltViewModel
class Loginviewmodel @Inject constructor(
    application: Application,
    private val api: Api
) : AndroidViewModel(application) {

    private  val _authstate = MutableStateFlow<Networkresult<String>>(Networkresult.Loading())
    val authstate = _authstate.asStateFlow()
    var _loading by mutableStateOf(false)

    var email by mutableStateOf("")
        private set
    var username by mutableStateOf("")
        private set
    var password by mutableStateOf("")
        private set
    var auth by mutableStateOf(false)

    val role = "user"


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

     fun onregister(username: String, email: String, password: String, role: String) {
        val call = api.registerUser(User(username, email, password,role))

        call.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    Toast.makeText(getApplication(), "Registration successful", Toast.LENGTH_SHORT).show()
                    Networkresult.Success("Registration successful")


                } else {
                    Toast.makeText(getApplication(), "Registration failed", Toast.LENGTH_SHORT).show()
                    Networkresult.Error("Registration failed")
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(getApplication(), "Please try again", Toast.LENGTH_SHORT).show()
                Networkresult.Error<String>("Please try again")
            }
        })
    }

     fun onlogin(password: String, email: String) {
        val call = api.loginUser(Loginuser(email, password))
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) =
                if (response.isSuccessful) {
                val loginResponse = response.body()
                val token = loginResponse.toString()
                // Extract token from logindata
                if (token != null) {
                    SecureTokenManager(getApplication()).saveToken(token as String)
                    auth = true // Update auth state upon successful login
                    Toast.makeText(getApplication(), "Login successful", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(getApplication(), "Login failed: No token", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(getApplication(),"Login failed: ${response.code()}", Toast.LENGTH_SHORT).show()
                println("Login failed: ${response.code()}")
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Toast.makeText(getApplication(), "Login failed: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

     fun onauth(value: String) {
        Networkresult.Loading<Any>()
         _loading = true

        val call = api.auth(value)
        call.enqueue(object : Callback<Boolean> {
            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                if (response.isSuccessful) {
                    _loading = false
                    auth = response.body() ?: false

                }
            }

            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                _loading = false
                auth = false
                Networkresult.Error<String>("Please relogin")
            }
        })
    }
}
