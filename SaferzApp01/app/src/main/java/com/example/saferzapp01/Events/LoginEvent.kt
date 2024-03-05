package com.example.saferzapp01.Events

sealed interface LoginEvent {
        data class SetEmail(val email:String):LoginEvent
        object CheckEmailValidity:LoginEvent
        data class SetPassword(val password:String):LoginEvent
        object CheckPasswordValidity:LoginEvent
        object PasswordVisibility:LoginEvent
        object Login:LoginEvent
        object gotoSignup:LoginEvent
}