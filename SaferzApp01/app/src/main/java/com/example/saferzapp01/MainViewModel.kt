package com.example.saferzmobileapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.saferzapp01.Events.LoginEvent
import com.example.saferzapp01.Events.SignupEvent
import com.example.saferzapp01.Repository.Repository
import com.example.saferzapp01.States.LoginState
import com.example.saferzapp01.States.SignupState
import com.example.saferzapp01.Utils.auth.SignUp.ValidateSignupForm
import com.example.saferzapp01.model.Login.LoginRequest
import com.example.saferzapp01.model.Signup.SignupRequest
import com.example.saferzapp01.model.Signup.SignupResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository:Repository):ViewModel() {
    //    splash screen code
    private val _loading = MutableStateFlow(true)
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
//            LoginEvent.gotoSignup -> TODO()
            LoginEvent.PasswordVisibility -> _loginState.update { it.copy(passwordHidden = !loginState.value.passwordHidden) }
            else->
            {
                val email = loginState.value.email
                val password = loginState.value.password
                viewModelScope.launch(Dispatchers.IO) {
                    val response=repository.login(signinBody = LoginRequest(email = email, password = password))
                    if(response.isSuccessful){Log.d("Response",response.body().toString())}
                    Log.d("Response error",response.body().toString()+response.code().toString())
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

            is SignupEvent.CheckEmailValidity-> {
                val emailValid = ValidateSignupForm().validateEmail(signupState.value.email)
                if (!emailValid.successful) {
                    _signupState.update {
                        it.copy(
                            isErrorEmail = true,
                            errorEmail = emailValid.errorMessage
                        )
                    }
                }
                else _signupState.update {
                    it.copy(
                        isErrorEmail = false,
                        errorEmail = ""
                    )
                }
            }

            SignupEvent.CheckUserNameValidity ->  { val userNameValid = ValidateSignupForm().validateUserName(signupState.value.userName)
            if (!userNameValid.successful) {
                _signupState.update {
                    it.copy(
                        isErrorUserName = true,
                        errorUserName = userNameValid.errorMessage
                    )
                }
            }
            else _signupState.update {
                it.copy(
                    isErrorUserName = false,
                    errorUserName = ""
                )
            }
        }

            SignupEvent.CheckFullNameValidity -> { val fullNameValid = ValidateSignupForm().validateFullName(signupState.value.fullName)
                if (!fullNameValid.successful) {
                    _signupState.update {
                        it.copy(
                            isErrorFullName = true,
                            errorFullName = fullNameValid.errorMessage
                        )
                    }
                }
                else _signupState.update {
                    it.copy(
                        isErrorFullName = false,
                        errorFullName = ""
                    )
                }
            }

            SignupEvent.CheckReligionValidity -> { val religionValid = ValidateSignupForm().validateReligion(signupState.value.religion)
                if (!religionValid.successful) {
                    _signupState.update {
                        it.copy(
                            isErrorReligion = true,
                            errorReligion = religionValid.errorMessage
                        )
                    }
                }
                else _signupState.update {
                    it.copy(
                        isErrorReligion = false,
                        errorReligion = ""
                    )
                }
            }
            SignupEvent.CheckDobValidity -> { val dobValid = ValidateSignupForm().validateDate(signupState.value.dob)
                if (!dobValid.successful) {
                    _signupState.update {
                        it.copy(
                            isErrorDate = true,
                            errorDob = dobValid.errorMessage
                        )
                    }
                }
                else _signupState.update {
                    it.copy(
                        isErrorDate = false,
                        errorDob = ""
                    )
                }
            }
            SignupEvent.CheckGenderValidity -> { val genderValid = ValidateSignupForm().validateGender(signupState.value.gender)
                if (!genderValid.successful) {
                    _signupState.update {
                        it.copy(
                            isErrorGender = true,
                            errorGender = genderValid.errorMessage
                        )
                    }
                }
                else _signupState.update {
                    it.copy(
                        isErrorGender = false,
                        errorGender = ""
                    )
                }
            }
            SignupEvent.CheckPasswordValidity -> { val passwordValid = ValidateSignupForm().validatePassword(signupState.value.password)
                if (!passwordValid.successful) {
                    _signupState.update {
                        it.copy(
                            isErrorPassword = true,
                            errorPassword = passwordValid.errorMessage
                        )
                    }
                }
                else _signupState.update {
                    it.copy(
                        isErrorPassword = false,
                        errorPassword = ""
                    )
                }
            }
            SignupEvent.CheckConfirmPasswordValidity ->{ val confirmPasswordValid = ValidateSignupForm().validateConfirmPassword(signupState.value.password,signupState.value.confirmPassword)
                if (!confirmPasswordValid.successful) {
                    _signupState.update {
                        it.copy(
                            isErrorConfirmPassword = true,
                            errorConfirmPassword = confirmPasswordValid.errorMessage
                        )
                    }
                }
                else _signupState.update {
                    it.copy(
                        isErrorConfirmPassword = false,
                        errorConfirmPassword = ""
                        )
                }
            }

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
                    Log.d("failed request", response.body().toString()+response.code().toString())
                }
            }
        }


    }
}
