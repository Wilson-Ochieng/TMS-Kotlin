package com.example.tms.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST



//SignUp

data class SignUpRequest(val email: String, val password: String)
data class SignUpResponse(
    val message :String,
    val status :Int
)

data class LoginRequest(val email: String, val password: String)
data class LoginResponse(
    val user: User,
    val message: String,
    val token: String,
    val isLoggedIn: Boolean
)
data class User(
    val id: Int,
    val name: String?,
    val email: String,
    val isValidEmail: Int,
    val email_verified_at: String?,
    val remember_token: String?,
    val created_at: String,
    val updated_at: String
)

interface ApiService {
    @POST("login")
    suspend fun loginUser(@Body request: LoginRequest): Response<LoginResponse>
}


interface SignUpApiService {
    @POST("register")
    suspend fun SignUpUser(@Body request:SignUpRequest): Response<SignUpResponse>
}

