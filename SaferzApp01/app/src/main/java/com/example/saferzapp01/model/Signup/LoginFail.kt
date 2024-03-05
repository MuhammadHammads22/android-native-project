package com.example.saferzapp01.model.Signup

import com.google.gson.annotations.SerializedName

data class LoginFail(
    @SerializedName("errors" ) var errors : Errors? = Errors()
)