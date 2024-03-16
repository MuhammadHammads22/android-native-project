package com.example.saferzapp01.States

data class ForgotPasswordState (
    val Password:String="",
    val errorPassword:String="",
    val isErrorPassword:Boolean?=null,
    val PasswordHidden:Boolean=true,
    val confirmPassword:String="",
    val errorConfirmPassword:String="",
    val isErrorConfirmPassword:Boolean?=null,
    val confirmPasswordHidden:Boolean=true,
    val changePassword:Boolean=false
)