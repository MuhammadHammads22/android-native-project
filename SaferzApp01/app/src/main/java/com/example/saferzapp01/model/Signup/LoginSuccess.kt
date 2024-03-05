package com.example.saferzapp01.model.Signup

import com.google.gson.annotations.SerializedName

data class LoginSuccess(
    val msg: String,
    @SerializedName("click here")
    val clickHere: String
)