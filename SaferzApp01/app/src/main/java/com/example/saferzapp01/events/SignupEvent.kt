package com.example.saferzapp01.Events

sealed interface SignupEvent {
        data class SetEmail(val email:String):
                SignupEvent
        object CheckEmailValidity:
                SignupEvent
        data class SetUserName(val userName:String):
                SignupEvent
        object CheckUserNameValidity:
                SignupEvent
        data class SetFullName(val fullName:String):
                SignupEvent
        object CheckFullNameValidity:
                SignupEvent
        data class SetReligion(val religion:String):
                SignupEvent
        object CheckReligionValidity:
                SignupEvent
        data class SetGender(val gender:String):
                SignupEvent
        object CheckGenderValidity:
                SignupEvent
        object ShowDatePickerDialog:
                SignupEvent
        data class SetDateOfBirth(val dob:String):
                SignupEvent
        object CheckDobValidity:
                SignupEvent
        object HideDatePickerDialog:
                SignupEvent
        data class SetPassword(val password:String):
                SignupEvent
        object CheckPasswordValidity:
                SignupEvent
        object PasswordVisibility:
                SignupEvent
        data class SetConfirmPassword(val confirmPassword:String):
                SignupEvent
        object CheckConfirmPasswordValidity:
                SignupEvent
        object ConfirmPasswordVisibility:
                SignupEvent
        object Signup: SignupEvent
        object GotoLogin: SignupEvent







}