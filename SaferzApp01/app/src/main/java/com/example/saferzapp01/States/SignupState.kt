package com.example.saferzapp01.States

data class SignupState(
    val activeScreen:Boolean=true,
    val userName:String="",
    val fullName:String="",
    val datePickerDialog:Boolean=false,
    val dob:String="",
    val religion:String="",
    val email:String="",
    val gender:String="",
    val password:String="",
    val passwordHidden:Boolean=true,
    val confirmPassword:String="",
    val confirmPasswordHidden:Boolean=true,
    val signup:Boolean=false
)
