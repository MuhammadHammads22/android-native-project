package com.example.saferzapp01.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.saferzapp01.Events.LoginEvent
import com.example.saferzapp01.Repository.Repository
import com.example.saferzapp01.States.LoginState
import com.example.saferzapp01.Utils.auth.SignUp.ValidateSignupForm
import com.example.saferzapp01.model.Login.LoginRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel@Inject constructor(private val repository: Repository): ViewModel()  {

    private val _loginState = MutableStateFlow(LoginState())
    val loginState = _loginState.asStateFlow()


    fun onLoginEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.SetEmail -> _loginState.update { it.copy(email = event.email) }

            is LoginEvent.CheckEmailValidity -> {
                val emailValid = ValidateSignupForm().validateEmail(loginState.value.email)
                if (!emailValid.successful) {
                    _loginState.update {
                        it.copy(
                            isErrorEmail = true,
                            errorEmail = emailValid.errorMessage
                        )
                    }
                } else {
                    _loginState.update {
                        it.copy(
                            isErrorEmail = false,
                            errorEmail = ""
                        )
                    }
                }
            }

            is LoginEvent.SetPassword -> _loginState.update { it.copy(password = event.password) }

            is LoginEvent.CheckPasswordValidity -> {
                val validPassword = ValidateSignupForm().validatePassword(loginState.value.password)
                if (!validPassword.successful) {
                    _loginState.update {
                        it.copy(
                            errorPassword = validPassword.errorMessage,
                            isErrorPassword = true
                        )
                    }
                } else {
                    _loginState.update {
                        it.copy(
                            errorPassword = "",
                            isErrorPassword = false
                        )
                    }
                }

            }

            LoginEvent.PasswordVisibility -> _loginState.update { it.copy(passwordHidden = !loginState.value.passwordHidden) }
            LoginEvent.gotoSignup -> TODO()
            else -> {
                val email = loginState.value.email
                val password = loginState.value.password
                viewModelScope.launch(Dispatchers.IO) {
                    val response = repository.login(
                        signinBody = LoginRequest(
                            email = email,
                            password = password
                        )
                    )
                    if (response.isSuccessful) {
                        Log.d("Response", response.body().toString())
                    }
                    Log.d("Response error", response.body().toString() + response.code().toString())
                }
            }
        }
    }
}