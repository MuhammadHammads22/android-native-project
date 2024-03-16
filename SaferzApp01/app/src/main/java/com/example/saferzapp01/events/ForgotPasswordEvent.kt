package com.example.saferzapp01.Events

sealed interface ForgotPasswordEvent {

    data class SetPassword(val password:String): ForgotPasswordEvent
    object CheckPasswordValidity: ForgotPasswordEvent
    object PasswordVisibility: ForgotPasswordEvent
    data class SetConfirmPassword(val confirmPassword:String):ForgotPasswordEvent
    object CheckConfirmPasswordValidity: ForgotPasswordEvent
    object ConfirmPasswordVisibility: ForgotPasswordEvent
    object Signup: ForgotPasswordEvent
    object GotoLogin: ForgotPasswordEvent

}