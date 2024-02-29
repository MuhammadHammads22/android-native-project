package com.example.saferzapp01.States

data class LoginState(
    val activeScreen:Boolean=false,
    val email:String="",
    val errorEmail:String="",
    val password:String="",
    val errorPassword:String="",
    val passwordHidden:Boolean=true,
    val login:Boolean=false
)
