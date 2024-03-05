package com.example.saferzapp01.Utils.auth.SignUp

import android.util.Log
import android.util.Patterns
import com.example.saferzapp01.Utils.Constants
import com.example.saferzapp01.Utils.auth.ValidationResult
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.Locale

class ValidateSignupForm {

    fun validateEmail(email: String): ValidationResult {
        if(email.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "*required"
            )
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(
                successful = false,
                errorMessage = "*not a valid email"
            )
        }
        return ValidationResult(
            successful = true
        )
    }

    fun validateUserName(userName: String): ValidationResult {
        if(userName.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "*Required"
            )
        }
        else if(userName.length<4){
            return ValidationResult(
                successful = false,
                errorMessage = "*not valid"
            )
        }

        return ValidationResult(
            successful = true
        )
    }

    fun validateFullName(fullName: String): ValidationResult {
        if(fullName.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "*Required"
            )
        }
        else if(fullName.length<4){
            return ValidationResult(
                successful = false,
                errorMessage = "*not valid"
            )
        }

        return ValidationResult(
            successful = true
        )
    }
    fun validateReligion(religion: String): ValidationResult {
        if(religion.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "*Required"
            )
        }
        if(religion.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() } !in Constants.religions){
            return ValidationResult(
                successful = false,
                errorMessage = "*Enter valid Religion"
            )
        }

        return ValidationResult(
            successful = true
        )
    }

    fun validateGender(gender: String): ValidationResult {
        if(gender.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "*Required"
            )
        }
        if(gender.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() } !in Constants.gender){
            return ValidationResult(
                successful = false,
                errorMessage = "*Enter valid gender"
            )
        }

        return ValidationResult(
            successful = true
        )
    }



    fun validateDate(dateStr: String): ValidationResult {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        if(dateStr.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "*Required"
            )
        }
        try {
            val date = formatter.parse(dateStr)
            if(formatter.format(date) == dateStr){
                return ValidationResult(successful = true)
            }
            else{
                return ValidationResult(successful = false,errorMessage = "*invalid date format")
            }
        } catch (e: DateTimeParseException) {
            Log.d("error",e.toString())
            return ValidationResult(successful = false,errorMessage = "*invalid date")
        }
    }



    fun validatePassword(password: String): ValidationResult {

        val containsLettersAndDigits = password.any { it.isDigit() } &&
                password.any { it.isLetter() }
        if (password.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "*Required"
            )
        } else if (password.length > 8 && containsLettersAndDigits) {
            return ValidationResult(
                successful = true,
                errorMessage = ""
            )
        } else {
            return ValidationResult(
                successful = false,
                errorMessage = "*weak password"
            )
        }
    }

    fun validateConfirmPassword(password: String, repeatedPassword: String): ValidationResult {

        if(repeatedPassword.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "*Required"
            )
        }
        else if(password != repeatedPassword) {
            return ValidationResult(
                successful = false,
                errorMessage = "unmatched password*"
            )
        }
        return ValidationResult(
            successful = true
        )
    }

}