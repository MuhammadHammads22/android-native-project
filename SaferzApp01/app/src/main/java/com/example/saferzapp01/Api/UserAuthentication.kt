package com.example.saferzapp01.Api

import com.example.saferzapp01.model.Login.LoginRequest
import com.example.saferzapp01.model.Login.LoginResponse
import com.example.saferzapp01.model.Signup.SignupRequest
import com.example.saferzapp01.model.Signup.SignupResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserAuthentication {

    @POST("/user/login/")
    suspend fun login(@Body signinBody:LoginRequest ):Response<LoginResponse>

    @POST("/user/register/")
//    @Headers(
//        "Content-Type: application/json",
//        "Accept: application/json",
//        "Content-Length: 61"
//    )
    suspend fun signup(@Body signupBody: SignupRequest):Response<SignupResponse>

}