package com.example.saferzapp01.Events

sealed interface SignupEvent {
        data class SetEmail(val email:String):SignupEvent
        data class SetUserName(val userName:String):SignupEvent
        data class SetFullName(val fullName:String):SignupEvent
        data class SetReligion(val religion:String):SignupEvent
        data class SetGender(val gender:String):SignupEvent
        object ShowDatePickerDialog:SignupEvent
        data class SetDateOfBirth(val dob:String):SignupEvent
        object HideDatePickerDialog:SignupEvent
        data class SetPassword(val password:String):SignupEvent
        object PasswordVisibility:SignupEvent
        data class SetConfirmPassword(val confirmPassword:String):SignupEvent
        object ConfirmPasswordVisibility:SignupEvent
        object Signup:SignupEvent
        object GotoLogin:SignupEvent
}