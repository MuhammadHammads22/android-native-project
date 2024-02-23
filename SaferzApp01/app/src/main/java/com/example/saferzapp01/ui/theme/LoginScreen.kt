@file:Suppress("DEPRECATION")

package com.example.Safers

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.example.saferzapp01.Events.SignupEvent
import com.example.saferzapp01.R
import com.example.saferzapp01.States.LoginState
import com.example.saferzapp01.States.SignupState
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun loginScreen(state:LoginState,event:(LoginEvent)->Unit) {

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
                supportingText = { Text(text = "", maxLines = 1) },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    // below line is used to specify our
                    // type of keyboard such as text, number, phone.
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
            )
        }
        item {
            OutlinedTextField(
                value = state.password,
                onValueChange = { event(LoginEvent.SetPassword(it)) },
                supportingText = { Text(text = "", maxLines = 1) },
                label = { Text("Password") },
                modifier = Modifier
                    .fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    // below line is used to specify our
                    // type of keyboard such as text, number, phone.
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next
                ),
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
                onClick = { event(LoginEvent.Login) },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
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
                    fontWeight = FontWeight.SemiBold,
                    textDecoration = TextDecoration.None
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun signUp(state:SignupState,event: (SignupEvent)->Unit) {
    LazyColumn(modifier= Modifier
        .fillMaxSize()
        .padding(horizontal = 15.dp),
        verticalArrangement =Arrangement.spacedBy(2.dp),
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
                onValueChange = { event(SignupEvent.SetEmail(it)) },
                supportingText={ Text(text = "", maxLines = 1)},
                label={Text("Email")},
                modifier = Modifier
                    .fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    // below line is used to specify our
                    // type of keyboard such as text, number, phone.
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
            )
        }
        item {
            OutlinedTextField(
                value = state.userName,
                onValueChange = { event(SignupEvent.SetUserName(it)) },
                label = { Text(text = "UserName")},
                supportingText={ Text(text = "", maxLines = 1)},
                modifier = Modifier
                    .fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    // below line is used to specify our
                    // type of keyboard such as text, number, phone.
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )
        }
        item {
            OutlinedTextField(
                value = state.fullName,
                onValueChange = { event(SignupEvent.SetFullName(it)) },
                label = { Text(text = "FullName")},
                supportingText={ Text(text = "", maxLines = 1)},
                modifier = Modifier
                    .fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    // below line is used to specify our
                    // type of keyboard such as text, number, phone.
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )
        }
        item {
            OutlinedTextField(
                value = state.religion,
                onValueChange = { event(SignupEvent.SetReligion(it)) },
                label = { Text(text = "Religion")},
                supportingText={ Text(text = "", maxLines = 1)},
                modifier = Modifier
                    .fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    // below line is used to specify our
                    // type of keyboard such as text, number, phone.
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )
        }
        item {
            Row(modifier=Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                OutlinedTextField(
                value = state.gender,
                onValueChange = { event(SignupEvent.SetGender(it)) },
                label={ Text(text = "Gender")},
                supportingText={ Text(text = "", maxLines = 1)},
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
            )

//
                OutlinedTextField(
                value = state.dob,
                onValueChange = {event(SignupEvent.SetDateOfBirth(it)) },
                label = { Text("DOB") },
                modifier= Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                supportingText={ Text(text = "format: yyyy/mmm/dd", maxLines = 1)},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next),
                trailingIcon = {
                    IconButton(onClick = { event(SignupEvent.ShowDatePickerDialog) }) {
                        Icon(painterResource(id = R.drawable.ic_calendar_month), contentDescription = "Calendar Button")
                    }
                }
            )

            if (state.datePickerDialog) {
                val datePickerState =
                    rememberDatePickerState(initialDisplayMode = DisplayMode.Picker)
                val confirmEnabled = remember {
                    derivedStateOf { datePickerState.selectedDateMillis != null }
                }
                DatePickerDialog(
                    onDismissRequest = {
                        event(SignupEvent.HideDatePickerDialog)
                    },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                val date = Date(datePickerState.selectedDateMillis!!)
                                val format = "yyyy-MMM-dd"
                                val formatter = SimpleDateFormat(format, Locale.getDefault())
                                val formattedDate = formatter.format(date)
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
        onValueChange = { event(SignupEvent.SetPassword(it)) },
        modifier = Modifier.fillMaxWidth(),
        supportingText={ Text(text = "", maxLines = 1)},
        singleLine = true,
        label = { Text("Password") },
        visualTransformation =
        if (state.passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Next),
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
                onValueChange = { event(SignupEvent.SetConfirmPassword(it)) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                label = { Text("Confirm Password") },
                supportingText={ Text(text = "", maxLines = 1)},
                visualTransformation =
                if (state.confirmPasswordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next),
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
                )
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
        item { Spacer(modifier = Modifier.height(100.dp)) }
    }
}
