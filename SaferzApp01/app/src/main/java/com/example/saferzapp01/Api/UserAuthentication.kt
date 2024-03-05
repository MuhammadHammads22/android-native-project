package com.example.saferzapp01.Api

import com.example.saferzapp01.model.Login.LoginRequest
import com.example.saferzapp01.model.Login.LoginResponse
import com.example.saferzapp01.model.Signup.LoginSuccess
import com.example.saferzapp01.model.Signup.SignupApiResponse
import com.example.saferzapp01.model.Signup.SignupRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserAuthentication {

    @POST("/user/login/")
    suspend fun login(@Body signinBody:LoginRequest ):Response<LoginResponse>


//    @Headers(
//        "Content-Type: application/json",
//        "Accept: application/json",
//        "Content-Length: 61"
//    )

    @POST("/user/register/")
    @Headers("Content-Type: application/json")
    suspend fun signup(@Body signupBody: SignupRequest):Response<LoginSuccess>

}
