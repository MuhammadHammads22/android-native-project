package com.example.saferzapp01.model.Signup

import com.google.gson.annotations.SerializedName

data class Errors(
    @SerializedName("email"    ) var email    : ArrayList<String> = arrayListOf(),
    @SerializedName("username" ) var username : ArrayList<String> = arrayListOf()
)
