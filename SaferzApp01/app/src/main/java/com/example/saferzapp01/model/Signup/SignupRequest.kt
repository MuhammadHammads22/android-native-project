package com.example.saferzapp01.model.Signup

data class SignupRequest(
    val email:String="",
    val username:String="",
    val full_name:String="",
    val religion:String="",
    val gender:String="",
    val date_of_birth:String="",
    val password:String="",
    val password2:String="",
)
