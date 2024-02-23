package com.example.saferzapp01.Api

import com.example.saferzapp01.model.Login.LoginRequest
import com.example.saferzapp01.model.Login.LoginResponse
import com.example.saferzapp01.model.Signup.SignupRequest
import com.example.saferzapp01.model.Signup.SignupResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAuthentication {

    @POST("/user/login/")
    suspend fun login(@Body signinBody:LoginRequest ):Response<LoginResponse>

    @POST("/user/register/")
    suspend fun signup(@Body signupBody: SignupRequest):Response<SignupResponse>

}