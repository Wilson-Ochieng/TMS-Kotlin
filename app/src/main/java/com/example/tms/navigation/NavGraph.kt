package com.example.tms.navigation

import LoginViewModel
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tms.screens.LoginScreen
import com.example.tms.screens.SignUpScreen
import com.example.tms.api.TokenManager

@Composable
fun NavGraph(
    navController: NavHostController,
    tokenManager: TokenManager,
    loginViewModel: LoginViewModel
) {
    NavHost(navController = navController, startDestination = Screens.LoginScreen.route) {
        composable(

            route = Screens.LoginScreen.route
        ){
            LoginScreen(
                navController = navController,
                viewModel = loginViewModel,
                tokenManager = tokenManager
            )


        }
        composable(Screens.SignUpScreen.route) {
            SignUpScreen(viewModel = loginViewModel, tokenManager = tokenManager)
        }
    }
}
