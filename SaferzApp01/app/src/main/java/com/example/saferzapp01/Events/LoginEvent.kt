package com.example.saferzapp01.Events

sealed interface LoginEvent {
        data class SetEmail(val firstName:String):LoginEvent
        data class SetPassword(val lastName:String):LoginEvent
        object Login:LoginEvent
        object gotoSignup:LoginEvent
}