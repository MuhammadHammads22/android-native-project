package com.example.saferzapp01.model.Signup

//data class SignupResponseBody(
//    val msg:String,
//    val loginUrl: String
//)
//data class SignupErrorResponse(val errors: Map<String, List<String>>)

sealed class SignupResponse {
    data class Success(val msg: String, val loginUrl: String) : SignupResponse()
    data class Error(val errors: Map<String, List<String>>) : SignupResponse()
}