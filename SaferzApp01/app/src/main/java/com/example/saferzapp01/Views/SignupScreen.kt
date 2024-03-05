package com.example.saferzapp01.Views

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.focusGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.example.saferzapp01.Events.SignupEvent
import com.example.saferzapp01.R
import com.example.saferzapp01.States.SignupState
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun signUp(state: SignupState, event: (SignupEvent)->Unit) {
    val focusManager = LocalFocusManager.current
    LazyColumn(modifier= Modifier
        .focusGroup()
        .fillMaxSize()
        .padding(horizontal = 15.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        item {
            Image(
                painter = painterResource(id = R.drawable.sefarz_logo),
                contentDescription = "logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            OutlinedTextField(
                value = state.email,
                onValueChange = { event(SignupEvent.SetEmail(it)) },
                supportingText={ if(state.isErrorEmail?:false) Text(text = state.errorEmail, maxLines = 1) },
                label={ Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                ,
                singleLine = true,
                isError = state.isErrorEmail?:false,
                keyboardOptions = KeyboardOptions(
                    // below line is used to specify our
                    // type of keyboard such as text, number, phone.
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext =  {
                    event(SignupEvent.CheckEmailValidity)
                    focusManager.moveFocus(FocusDirection.Next)
                })
            )
        }
        item {
//            val focusRequester = remember { FocusRequester() }

            OutlinedTextField(
                value = state.userName,
                onValueChange = { event(SignupEvent.SetUserName(it)) },
                label = { Text(text = "UserName") },
                supportingText={ Text(text = state.errorUserName, maxLines = 1) },
                modifier = Modifier
                    .fillMaxWidth()
                ,
                singleLine = true,
                isError = state.isErrorUserName?:false,
                keyboardOptions = KeyboardOptions(
                    // below line is used to specify our
                    // type of keyboard such as text, number, phone.
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,

                )
                ,keyboardActions = KeyboardActions(onNext = {
                    event(SignupEvent.CheckUserNameValidity)
                    focusManager.moveFocus(FocusDirection.Next)
                })
            )
        }
        item {
            OutlinedTextField(
                value = state.fullName,
                onValueChange = { event(SignupEvent.SetFullName(it)) },
                label = { Text(text = "FullName") },
                isError = state.isErrorFullName?:false,
                supportingText={ Text(text = state.errorFullName, maxLines = 1) },
                modifier = Modifier
                    .fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    // below line is used to specify our
                    // type of keyboard such as text, number, phone.
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext =  {
                    event(SignupEvent.CheckFullNameValidity)
                    focusManager.moveFocus(FocusDirection.Next)
                })
            )
        }
        item {
            OutlinedTextField(
                value = state.religion,
                onValueChange = { event(SignupEvent.SetReligion(it)) },
                label = { Text(text = "Religion") },
                supportingText={ Text(text = state.errorReligion, maxLines = 1) },
                modifier = Modifier
                    .fillMaxWidth(),
                singleLine = true,
                isError = state.isErrorReligion?:false,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext =  {
                    event(SignupEvent.CheckReligionValidity)
                    focusManager.moveFocus(FocusDirection.Next)
                })
            )
        }
        item {
            Row(modifier= Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                OutlinedTextField(
                    value = state.gender,
                    onValueChange = { event(SignupEvent.SetGender(it)) },
                    label={ Text(text = "Gender") },
                    supportingText={ Text(text = state.errorGender, maxLines = 1) },
                    isError = state.isErrorGender?:false,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        // below line is used to specify our
                        // type of keyboard such as text, number, phone.
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    )
                    ,keyboardActions= KeyboardActions(onNext = {
                        event(SignupEvent.CheckGenderValidity)
                        focusManager.moveFocus(FocusDirection.Next)
                    }
                            )
                )
//
                OutlinedTextField(
                    value = state.dob,
                    onValueChange = {event(SignupEvent.SetDateOfBirth(it)) },
                    label = { Text("DOB") },
                    modifier= Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    singleLine = true,
                    supportingText={ Text(text = state.errorDob, maxLines = 1) },
                    isError = state.isErrorDate?:false,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(onNext = {
                        event(SignupEvent.CheckDobValidity)
                        focusManager.moveFocus(FocusDirection.Down)
                    }),
                    trailingIcon = {
                        IconButton(onClick = { event(SignupEvent.ShowDatePickerDialog) }) {
                            Icon(painterResource(id = R.drawable.ic_calendar_month), contentDescription = "Calendar Button")
                        }
                    }
                )
                val datePickerState =
                    rememberDatePickerState()
                val confirmEnabled = remember {
                    derivedStateOf { datePickerState.selectedDateMillis != null }
                }
                if (state.datePickerDialog) {
                    DatePickerDialog(
                        onDismissRequest = {
                            event(SignupEvent.HideDatePickerDialog)
                        },
                        properties = DialogProperties(),
                        confirmButton = {
                            TextButton(
                                onClick = {
                                    val date = Date(datePickerState.selectedDateMillis!!)
                                    val format = "yyyy-MM-dd"
                                    val formatter = SimpleDateFormat(format, Locale.getDefault())
                                    val formattedDate = formatter.format(date)
                                    Log.d("date",formattedDate)
                                    event(SignupEvent.SetDateOfBirth(formattedDate))
                                },
                                enabled = confirmEnabled.value
                            ) {
                                Text("OK")
                            }
                        },
                        dismissButton = {
                            TextButton(
                                onClick = {
                                    event(SignupEvent.HideDatePickerDialog)
                                }
                            ) {
                                Text("Cancel")
                            }
                        }
                    ) {
                        DatePicker(state = datePickerState)
                    }
                }
            }

        }
        item {
            OutlinedTextField(
                value = state.password,
                onValueChange = {
                    event(SignupEvent.SetPassword(it))
                    if(it.length>2) {
                        event(SignupEvent.CheckPasswordValidity)
                        if (state.confirmPassword.length > 2) event(SignupEvent.CheckConfirmPasswordValidity)
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                supportingText={ Text(text = state.errorPassword, maxLines = 1) },
                isError = state.isErrorPassword?:false,
                singleLine = true,
                label = { Text("Password") },
                visualTransformation =
                if (state.passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = {
                    event(SignupEvent.CheckPasswordValidity)
                    focusManager.moveFocus(FocusDirection.Down)
                }),
                trailingIcon = {
                    IconButton(onClick = { event(SignupEvent.PasswordVisibility) }) {
                        val visibilityIcon =
                            if (state.passwordHidden) R.drawable.ic_visibility else R.drawable.ic_visibility_off
                        // Please provide localized description for accessibility services
                        val description =
                            if (state.passwordHidden) "Show password" else "Hide password"
                        Icon(
                            painter = painterResource(visibilityIcon),
                            contentDescription = description
                        )
                    }
                }
            )
        }


        item {
            OutlinedTextField(
                value = state.confirmPassword,
                onValueChange = {
                    event(SignupEvent.SetConfirmPassword(it))
                    event(SignupEvent.CheckConfirmPasswordValidity)
                                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                label = { Text("Confirm Password") },
                supportingText={ Text(text = state.errorConfirmPassword, maxLines = 1) },
                isError = state.isErrorConfirmPassword?:false,
                visualTransformation =
                if (state.confirmPasswordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                    focusManager.moveFocus(FocusDirection.Down)
                }),
                trailingIcon = {
                    IconButton(onClick = { event(SignupEvent.ConfirmPasswordVisibility) }) {
                        val visibilityIcon =
                            if (state.confirmPasswordHidden) R.drawable.ic_visibility else R.drawable.ic_visibility_off
                        // Please provide localized description for accessibility services
                        val description =
                            if (state.confirmPasswordHidden) "Show password" else "Hide password"
                        Icon(painter = painterResource(visibilityIcon), contentDescription = description)
                    }
                }
            )
        }

        item {
            Button(
                onClick = {event(SignupEvent.Signup)}, modifier = Modifier
                    .fillMaxWidth()
                ,colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                enabled = if(!(state.isErrorEmail?:true) && !(state.isErrorUserName?:true) && !(state.isErrorFullName?:true) && !(state.isErrorReligion?:true) && !(state.isErrorGender?:true) && !(state.isErrorReligion?:true) && !(state.isErrorPassword?:true) && !(state.isErrorConfirmPassword?:true) ) {
                     true
                }
                else false

            ) {
                Text(text = "SignUp")
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp), horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Already have an account?  ", color = Color.Black,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Light,
                    textDecoration = TextDecoration.None
                )

                Text(
                    text = "Login", color = Color.Black,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold,
                    textDecoration = TextDecoration.None
                )
            }
        }
        item { Box(modifier = Modifier.height(300.dp)) }
    }

}