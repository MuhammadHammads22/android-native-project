@file:Suppress("DEPRECATION")

package com.example.Safers

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.example.saferzapp01.Events.LoginEvent
import com.example.saferzapp01.R
import com.example.saferzapp01.States.LoginState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(state:LoginState, event:(LoginEvent)->Unit,navigateToSignup:()->Unit,navigateToForgotPassword:()->Unit,navigateToMainGraph:()->Unit,navigateToTermsAndCondition:()->Unit) {
    val focusManager= LocalFocusManager.current
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {

        item {
            Image(
                painter = painterResource(id = com.example.saferzapp01.R.drawable.sefarz_logo),
                contentDescription = "logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            OutlinedTextField(
                value = state.email,
                onValueChange = { event(LoginEvent.SetEmail(it)) },
                supportingText = { Text(text = state.errorEmail, maxLines = 1) },
                isError = state.isErrorEmail?:false,
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    // below line is used to specify our
                    // type of keyboard such as text, number, phone.
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    event(LoginEvent.CheckEmailValidity)
                    focusManager.moveFocus(FocusDirection.Next)
                })
            )
        }
        item {
            OutlinedTextField(
                value = state.password,
                onValueChange = {
                    event(LoginEvent.SetPassword(it))
                    if(it.length>2) event(LoginEvent.CheckPasswordValidity)
                                },
                supportingText = { Text(text = state.errorPassword, maxLines = 1) },
                isError = state.isErrorPassword?:false,
                label = { Text("Password") },
                modifier = Modifier
                    .fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {
                    focusManager.moveFocus(FocusDirection.Down)
                }),
                visualTransformation =
                if (state.passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                trailingIcon = {
                    IconButton(onClick = { event(LoginEvent.PasswordVisibility) }) {
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
            Button(
                onClick = {
//                    event(LoginEvent.Login)
                      navigateToMainGraph()
                          },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                enabled =
//                if(!(state.isErrorEmail?:true) && !(state.isErrorPassword?:true) ) {
                    true
//                }
//                else false
            ) {
                Text(text = "Login")
            }

        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp), horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Dont have an account?  ", color = Color.Black,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Light,
                    textDecoration = TextDecoration.None
                )

                Text(
                    text = "SignUp", color = Color.Black,
                    fontSize = 10.sp,
                    modifier=Modifier.clickable { navigateToSignup() },
                    fontWeight = FontWeight.SemiBold,
                    textDecoration = TextDecoration.None
                )
            }
        }
    }
}


