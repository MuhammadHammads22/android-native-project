package com.example.saferzapp01.Events

sealed interface SignupEvent {
        data class SetName(val lastName:String):SignupEvent
        data class SetEmail(val phoneNumber:String):SignupEvent
        data class SetReligion(val phoneNumber:String):SignupEvent
        data class SetDateOfBirth(val phoneNumber:String):SignupEvent
        data class SetPassword(val phoneNumber:String):SignupEvent
        data class SetConfirmPassword(val phoneNumber:String):SignupEvent
        object Signup:SignupEvent
        object GotoLogin:SignupEvent
}