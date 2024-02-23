package com.example.saferzmobileapp

import android.net.http.HttpException
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.saferzapp01.Events.LoginEvent
import com.example.saferzapp01.Events.SignupEvent
import com.example.saferzapp01.Repository.Repository
import com.example.saferzapp01.States.LoginState
import com.example.saferzapp01.States.SignupState
import com.example.saferzapp01.model.Login.LoginRequest
import com.example.saferzapp01.model.Signup.SignupRequest
import com.example.saferzapp01.model.Signup.SignupResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.updateAndGet
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor( val repository:Repository):ViewModel() {
    //    splash screen code
    val _loading = MutableStateFlow(true)
    val loading = _loading.asStateFlow()

    init {
        viewModelScope.launch {
            delay(3000L)
            _loading.value = false
        }
    }

    //    splash screen code
    private val _loginState = MutableStateFlow(LoginState())
    val loginState = _loginState.asStateFlow()
    private val _signupState = MutableStateFlow(SignupState())
    val signupState = _signupState.asStateFlow()
    fun onLoginEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.SetEmail -> _loginState.update { it.copy(email = event.email) }
            is LoginEvent.SetPassword -> _loginState.update { it.copy(password = event.password) }
            LoginEvent.gotoSignup -> TODO()
            LoginEvent.PasswordVisibility -> _loginState.update { it.copy(passwordHidden = !loginState.value.passwordHidden) }
            else->
            {
                val email = loginState.value.email
                val password = loginState.value.password
                viewModelScope.launch(Dispatchers.IO) {
                    repository.login(signinBody = LoginRequest(email = email, password = password))

            }
        }
        }
    }

    fun onSignupEvent(event: SignupEvent) {
        when (event) {
            is SignupEvent.SetEmail -> _signupState.update { it.copy(email = event.email) }
            is SignupEvent.SetUserName -> _signupState.update { it.copy(userName = event.userName) }
            is SignupEvent.SetFullName -> _signupState.update { it.copy(fullName = event.fullName) }
            is SignupEvent.SetReligion -> _signupState.update { it.copy(religion = event.religion) }
            is SignupEvent.SetGender -> _signupState.update { it.copy(gender = event.gender) }
            is SignupEvent.SetDateOfBirth -> _signupState.update { it.copy(dob = event.dob , datePickerDialog = false) }
            is SignupEvent.SetPassword -> _signupState.update { it.copy(password = event.password) }
            is SignupEvent.SetConfirmPassword -> _signupState.update { it.copy(confirmPassword = event.confirmPassword) }

            SignupEvent.GotoLogin -> TODO()
            SignupEvent.HideDatePickerDialog -> _signupState.update { it.copy(datePickerDialog = false) }
            SignupEvent.ShowDatePickerDialog -> _signupState.update { it.copy(datePickerDialog = true) }
            SignupEvent.ConfirmPasswordVisibility ->_signupState.update { it.copy(confirmPasswordHidden = !signupState.value.confirmPasswordHidden) }
            SignupEvent.PasswordVisibility -> _signupState.update { it.copy(passwordHidden = !signupState.value.passwordHidden) }
            else -> {
                val username = signupState.value.userName
                val fullName = signupState.value.fullName
                val email = signupState.value.email
                val religion = signupState.value.religion
                val gender = signupState.value.gender
                val dob = signupState.value.dob
                val password = signupState.value.password
                val confirmPassword = signupState.value.confirmPassword
                val body = SignupRequest(
                    email = email,
                    username = username,
                    full_name = fullName,
                    religion = religion,
                    gender = gender,
                    date_of_birth = dob,
                    password = password,
                    password2 = confirmPassword
                )
                Log.d("Response Body", body.toString())
                var response: Response<SignupResponse> = Response.error(
                    400,
                    "Empty response".toResponseBody(null)
                )
                Log.d("Response", "before response")

                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        response =
                            repository.signup(
                                signupBody = body
                            )
                    } catch (e: Exception) {
                        Log.d("Response error main", e.toString())
                    }

                    _signupState.update {
                        it.copy(
                            email = "",
                            userName = "",
                            fullName = "",
                            religion = "",
                            gender = "",
                            dob = "",
                            password = "",
                            confirmPassword = "",
                        )
                    }
                    if (response.isSuccessful) Log.d("Response Success", response.body().toString())
                    Log.d("failed request", response.code().toString())
                }
            }
        }


    }
}