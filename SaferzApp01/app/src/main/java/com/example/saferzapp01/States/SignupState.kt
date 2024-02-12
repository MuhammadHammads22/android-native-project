package com.example.saferzapp01.States

data class SignupState(
    val activeScreen:Boolean=true,
    val name:String="",
    val birthDate:String="",
    val religion:String="",
    val email:String="",
    val password:String="",
    val confirmPassword:String="",
    val signup:Boolean=false
)
