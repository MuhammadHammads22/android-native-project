package com.example.saferzapp01.States

data class LoginState(
    val activeScreen:Boolean=false,
    val email:String="",
    val password:String="",
    val login:Boolean=false
)
