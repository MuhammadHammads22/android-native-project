package com.example.saferzapp01.Repository

import com.example.saferzapp01.Api.RetrofitInstance
import com.example.saferzapp01.model.Login.LoginRequest
import com.example.saferzapp01.model.Login.LoginResponse
import com.example.saferzapp01.model.Signup.SignupRequest
import com.example.saferzapp01.model.Signup.SignupResponse
import retrofit2.Response


class Repository {
        suspend fun login(signinBody:LoginRequest):Response<LoginResponse>{
            return RetrofitInstance.UserAuthenticationApi.login(signinBody)
        }
        suspend fun signup(signupBody:SignupRequest):Response<SignupResponse>{
            return RetrofitInstance.UserAuthenticationApi.signup(signupBody)
        }
}