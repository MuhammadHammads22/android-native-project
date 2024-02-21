package com.example.saferzapp01.Events

sealed interface LoginEvent {
        data class SetEmail(val email:String):LoginEvent
        data class SetPassword(val password:String):LoginEvent
        object Login:LoginEvent
        object gotoSignup:LoginEvent
}