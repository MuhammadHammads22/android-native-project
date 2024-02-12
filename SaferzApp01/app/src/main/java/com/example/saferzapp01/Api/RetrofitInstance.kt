package com.example.saferzapp01.Api

import com.example.saferzapp01.Utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder().
        baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val UserAuthenticationApi:UserAuthentication by lazy {
        retrofit.create(UserAuthentication::class.java)
    }
}