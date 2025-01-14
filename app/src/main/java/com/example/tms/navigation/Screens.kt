package com.example.tms.navigation

sealed class Screens(var route:String) {
    data object LoginScreen:Screens(route = "login" )
    data object SignUpScreen:Screens(route = "signup" )
}