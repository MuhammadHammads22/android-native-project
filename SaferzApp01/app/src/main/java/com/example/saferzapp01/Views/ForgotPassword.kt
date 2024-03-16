package com.example.saferzapp01.Views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.saferzapp01.Events.ForgotPasswordEvent
import com.example.saferzapp01.Events.SignupEvent
import com.example.saferzapp01.R
import com.example.saferzapp01.States.ForgotPasswordState

@Composable
fun ForgotPassword(state: ForgotPasswordState, event:(ForgotPasswordEvent)->Unit) {
    val focusManager = LocalFocusManager.current
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            OutlinedTextField(
                value = state.Password,
                onValueChange = {
                    event(ForgotPasswordEvent.SetPassword(it))
                    if (it.length > 2) {
                        event(ForgotPasswordEvent.CheckPasswordValidity)
                        if (state.confirmPassword.length > 2) event(ForgotPasswordEvent.CheckConfirmPasswordValidity)
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                supportingText = { Text(text = state.errorPassword, maxLines = 1) },
                isError = state.isErrorPassword ?: false,
                singleLine = true,
                label = { Text("Password") },
                visualTransformation =
                if (state.PasswordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    event(ForgotPasswordEvent.CheckPasswordValidity)
                    focusManager.moveFocus(FocusDirection.Down)
                }),
                trailingIcon = {
                    IconButton(onClick = { event(ForgotPasswordEvent.PasswordVisibility) }) {
                        val visibilityIcon =
                            if (state.PasswordHidden) R.drawable.ic_visibility else R.drawable.ic_visibility_off
                        // Please provide localized description for accessibility services
                        val description =
                            if (state.PasswordHidden) "Show password" else "Hide password"
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
                    event(ForgotPasswordEvent.SetConfirmPassword(it))
                    event(ForgotPasswordEvent.CheckConfirmPasswordValidity)
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                label = { Text("Confirm Password") },
                supportingText = { Text(text = state.errorConfirmPassword, maxLines = 1) },
                isError = state.isErrorConfirmPassword ?: false,
                visualTransformation =
                if (state.confirmPasswordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {
                    focusManager.moveFocus(FocusDirection.Down)
                }),
                trailingIcon = {
                    IconButton(onClick = { event(ForgotPasswordEvent.ConfirmPasswordVisibility) }) {
                        val visibilityIcon =
                            if (state.confirmPasswordHidden) R.drawable.ic_visibility else R.drawable.ic_visibility_off
                        // Please provide localized description for accessibility services
                        val description =
                            if (state.confirmPasswordHidden) "Show password" else "Hide password"
                        Icon(
                            painter = painterResource(visibilityIcon),
                            contentDescription = description
                        )
                    }
                }
            )
        }
        item {
            Button(
                onClick = { event(ForgotPasswordEvent.Signup) }, modifier = Modifier
                    .fillMaxWidth(), colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                enabled = if (!(state.isErrorPassword ?: true) && !(state.isErrorConfirmPassword
                        ?: true)
                ) {
                    true
                } else false

            ) {
                Text(text = "SignUp")
            }


        }
    }
}