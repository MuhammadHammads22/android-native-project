package com.example.saferzapp01.model.Signup

import com.google.gson.annotations.SerializedName
import org.xmlpull.v1.XmlSerializer
class SignupApiResponse(){
    data class Success(val data:LoginSuccess)
    data class Fail(val data:LoginFail)
}
//sealed class SignupApiResponse () {
//   data class Success(
//       @SerializedName("click here")
//       val clickHere: String,
//       val msg: String
//   ):SignupApiResponse()
//
//    data class Errors(
//        val errors: com.example.saferzapp01.model.Signup.Errors,
//    ):SignupApiResponse()
//}
