package com.example.saferzapp01.States

import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember

data class SignupState@OptIn(ExperimentalMaterial3Api::class) constructor(
    val activeScreen:Boolean=true,
    val email:String="",
    val errorEmail:String="",
    val isErrorEmail:Boolean?=null,
    val userName:String="",
    val errorUserName:String="",
    val isErrorUserName:Boolean?=null,
    val fullName:String="",
    val errorFullName:String="",
    val isErrorFullName:Boolean?=null,
    val datePickerDialog:Boolean=false,
    val dob:String="",
    val errorDob:String="format: 1999-01-06",
    val isErrorDate:Boolean?=null,
    val religion:String="",
    val errorReligion:String="",
    val isErrorReligion:Boolean?=null,
    val gender:String="",
    val errorGender:String="",
    val isErrorGender:Boolean?=null,
    val password:String="",
    val errorPassword:String="",
    val isErrorPassword:Boolean?=null,
    val passwordHidden:Boolean=true,
    val confirmPassword:String="",
    val errorConfirmPassword:String="",
    val isErrorConfirmPassword:Boolean?=null,
    val confirmPasswordHidden:Boolean=true,
    val signup:Boolean=false
)
