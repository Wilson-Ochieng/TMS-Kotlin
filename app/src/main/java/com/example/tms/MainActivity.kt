package com.example.tms

import LoginRepository
import LoginViewModel
import RetrofitInstance
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.tms.api.ApiService
import com.example.tms.api.TokenManager
import com.example.tms.navigation.NavGraph
import com.example.tms.screens.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tokenManager = TokenManager(this)
        val apiService = RetrofitInstance.retrofit.create(ApiService::class.java)
        val loginRepository = LoginRepository(apiService)
        val loginViewModel = LoginViewModel(loginRepository)


        setContent {
            val navController = rememberNavController()
            NavGraph(
                navController = navController,
                tokenManager = tokenManager,
                loginViewModel = loginViewModel
            )

        }
    }
}


