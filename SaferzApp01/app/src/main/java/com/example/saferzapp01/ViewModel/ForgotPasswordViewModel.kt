package com.example.saferzapp01.ViewModel

import androidx.lifecycle.ViewModel
import com.example.saferzapp01.Events.ForgotPasswordEvent
import com.example.saferzapp01.Events.SignupEvent
import com.example.saferzapp01.Repository.Repository
import com.example.saferzapp01.States.ForgotPasswordState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class ForgotPasswordViewModel@Inject constructor(private val repository: Repository): ViewModel()  {

    private val _forgotPasswordState = MutableStateFlow(ForgotPasswordState())
    val forgotPasswordState = _forgotPasswordState.asStateFlow()


    fun onResetPasswordEvent(event:ForgotPasswordEvent){
    }
}