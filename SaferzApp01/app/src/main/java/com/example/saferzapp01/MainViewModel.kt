package com.example.saferzmobileapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.saferzapp01.Events.SignupEvent
import com.example.saferzapp01.States.LoginState
import com.example.saferzapp01.States.SignupState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    private val _loading= MutableStateFlow(true)
    val loading=_loading.asStateFlow()

    private val _signupState= MutableStateFlow(SignupState())
    val signupState=_signupState.asStateFlow()

    init {
        viewModelScope.launch {
            delay(3000L)
            _loading.value=false
        }
    }

}
fun signupEvent(event:SignupEvent){
    when(event){
        is SignupEvent.GotoLogin -> TODO()
        is SignupEvent.SetConfirmPassword -> TODO()
        is SignupEvent.SetDateOfBirth -> TODO()
        is SignupEvent.SetEmail -> TODO()
        is SignupEvent.SetName -> TODO()
        is SignupEvent.SetPassword -> TODO()
        is SignupEvent.SetReligion -> TODO()
        is SignupEvent.Signup -> TODO()
    }
}