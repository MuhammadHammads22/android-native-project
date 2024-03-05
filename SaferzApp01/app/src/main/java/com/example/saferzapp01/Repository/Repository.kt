package com.example.saferzapp01.Repository

import com.example.saferzapp01.Api.UserAuthentication
import com.example.saferzapp01.model.Login.LoginRequest
import com.example.saferzapp01.model.Login.LoginResponse
import com.example.saferzapp01.model.Signup.LoginSuccess
import com.example.saferzapp01.model.Signup.SignupApiResponse
import com.example.saferzapp01.model.Signup.SignupRequest
import retrofit2.Response
import javax.inject.Inject


class Repository @Inject constructor(val api:UserAuthentication) {
        suspend fun login(signinBody:LoginRequest):Response<LoginResponse>{
            return api.login(signinBody)
        }
        suspend fun signup(signupBody:SignupRequest):Response<LoginSuccess>{
            return api.signup(signupBody)
        }

}