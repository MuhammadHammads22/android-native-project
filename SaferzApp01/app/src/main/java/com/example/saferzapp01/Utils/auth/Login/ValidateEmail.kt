package com.example.saferzapp01.Utils.auth.Login

import android.util.Patterns
import com.example.saferzapp01.Utils.auth.ValidationResult

class ValidateEmail {

    fun execute(email: String): ValidationResult {
        if(email.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "blank email*"
            )
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(
                successful = false,
                errorMessage = "not a valid email*"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}