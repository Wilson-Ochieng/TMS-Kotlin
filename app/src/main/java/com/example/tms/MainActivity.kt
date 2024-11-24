package com.example.tms

import LoginRepository
import LoginViewModel
import RetrofitInstance
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tms.api.ApiService
import com.example.tms.api.TokenManager
import com.example.tms.components.LoginScreen
import com.example.tms.ui.theme.TMSTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tokenManager = TokenManager(this)
        val apiService = RetrofitInstance.retrofit.create(ApiService::class.java)
        val loginRepository = LoginRepository(apiService)
        val loginViewModel = LoginViewModel(loginRepository)


        setContent {
            LoginScreen(viewModel = loginViewModel, tokenManager = tokenManager)

        }
    }
}


