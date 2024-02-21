@file:Suppress("DEPRECATION")

package com.example.instagramui.Safers

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun loginScreen(state:LoginState,event:(LoginEvent)->Unit){
        Column (modifier= Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .offset(y = -40.dp), verticalArrangement =Arrangement.Center
            , horizontalAlignment = Alignment.CenterHorizontally ) {
            Image(painter = painterResource(id =com.example.saferzapp01.R.drawable.sefarz_logo) , contentDescription ="logo"
                , contentScale = ContentScale.Crop , modifier = Modifier.size(200.dp))
            TextField(value = state.email, onValueChange = {event(LoginEvent.SetEmail(it))}, placeholder = { Text(text = "Email") },modifier= Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
                shape= RoundedCornerShape(30.dp),
                colors = TextFieldDefaults.textFieldColors(focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    disabledTextColor = Color.Transparent,
                    )
                , singleLine = true
                , keyboardOptions =  KeyboardOptions(
                    // below line is used to specify our
                    // type of keyboard such as text, number, phone.
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ))
            TextField(value = state.password, onValueChange = {event(LoginEvent.SetPassword(it))}, placeholder = { Text(text = "Password") },modifier= Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
                ,shape= RoundedCornerShape(30.dp),
                colors = TextFieldDefaults.run {
                    textFieldColors(
                                unfocusedTextColor =  Color.Gray,
                                disabledTextColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent
                            )
                },
                visualTransformation = PasswordVisualTransformation()
                , keyboardOptions =  KeyboardOptions(
                    // below line is used to specify our
                    // type of keyboard such as text, number, phone.
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            , singleLine = true
            )

            Text(text = "Forgot password?", color = Color.Black,
                fontSize = 10.sp,
                fontWeight = FontWeight.SemiBold,
                textDecoration = TextDecoration.None,
                modifier= Modifier
                    .padding(top = 12.dp, end = 15.dp)
                    .align(Alignment.End)
            )

            Button(onClick = {event(LoginEvent.Login)}, modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
                .clip(RoundedCornerShape(10.dp))
            , colors= ButtonDefaults.buttonColors(
                    containerColor = Color.Black
            ) ){
                Text(text = "Login")
            }


            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
                , horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically){
                Text(text = "Dont have an account?  ",color = Color.Black,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Light,
                    textDecoration = TextDecoration.None)

                Text(text = "SignUp", color = Color.Black,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold,
                    textDecoration = TextDecoration.None)
            }
        }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun signUp(state:SignupState,event: (SignupEvent)->Unit) {
    LazyColumn {
//    (modifier= Modifier
//        .fillMaxSize()
//        .padding(horizontal = 16.dp)
//        .offset(y = -40.dp), verticalArrangement =Arrangement.Center
//        , horizontalAlignment = Alignment.CenterHorizontally )
        item {
            Image(
                painter = painterResource(id = com.example.saferzapp01.R.drawable.sefarz_logo),
                contentDescription = "logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            TextField(
                value = state.email,
                onValueChange = { event(SignupEvent.SetEmail(it)) },
                placeholder = { Text(text = "Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                shape = RoundedCornerShape(30.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    disabledTextColor = Color.Transparent,
                ),
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
            TextField(
                value = state.userName,
                onValueChange = { event(SignupEvent.SetUserName(it)) },
                placeholder = { Text(text = "User Name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                shape = RoundedCornerShape(30.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    disabledTextColor = Color.Transparent,
                ),
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
            TextField(
                value = state.fullName,
                onValueChange = { event(SignupEvent.SetFullName(it)) },
                placeholder = { Text(text = "Full Name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                shape = RoundedCornerShape(30.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    disabledTextColor = Color.Transparent,
                ),
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
            TextField(
                value = state.religion,
                onValueChange = { event(SignupEvent.SetReligion(it)) },
                placeholder = { Text(text = "Religion") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                shape = RoundedCornerShape(30.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    disabledTextColor = Color.Transparent,
                ),
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
            TextField(
                value = state.gender,
                onValueChange = { event(SignupEvent.SetGender(it)) },
                placeholder = { Text(text = "Gender") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                shape = RoundedCornerShape(30.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    disabledTextColor = Color.Transparent,
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    // below line is used to specify our
                    // type of keyboard such as text, number, phone.
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )

//            Text(text = state.dob,modifier = Modifier
//                .clickable { SignupEvent.ShowDatePickerDialog }
//                .fillMaxWidth()
//                .padding(top = 12.dp)
//                .clip(RoundedCornerShape(30.dp))
//                .background(color = Color.LightGray)
//                , color = Color.Gray)

            TextField(
                value = state.dob,
                onValueChange = { text = it },
                label = { Text("yyyy-MM-dd") },
                leadingIcon = { Icon(Icons.Filled.Favorite, contentDescription = "Localized description") },
                trailingIcon = { Icon(Icons.Filled.Info, contentDescription = "Localized description") }
            )

            Button(onClick = { event(SignupEvent.ShowDatePickerDialog) }, modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(30.dp))
                ) {
                Text(text = state.dob)
            }
//            Text(
//                text = state.dob,
//                onValueChange = { event(SignupEvent.SetDateOfBirth(it)) },
//                placeholder = { Text(text = "Birth Date") },
//                modifier = Modifier
//                    .clickable { SignupEvent.ShowDatePickerDialog }
//                    .fillMaxWidth()
//                    .padding(top = 12.dp),
//                shape = RoundedCornerShape(30.dp),
//                colors = TextFieldDefaults.textFieldColors(
//                    focusedIndicatorColor = Color.Transparent,
//                    unfocusedIndicatorColor = Color.Transparent,
//                    disabledIndicatorColor = Color.Transparent,
//                    disabledTextColor = Color.Transparent,
//                ),
//                singleLine = true,
//                keyboardOptions = KeyboardOptions(
//                    // below line is used to specify our
//                    // type of keyboard such as text, number, phone.
//                    keyboardType = KeyboardType.Text,
//                    imeAction = ImeAction.Next
//                )
//            )

            // TODO demo how to read the selected date from the state.
            if (state.datePickerDialog) {
                val datePickerState =
                    rememberDatePickerState(initialDisplayMode = DisplayMode.Input)
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

        item {
            TextField(
                value = state.password,
                onValueChange = { event(SignupEvent.SetPassword(it)) },
                singleLine = true,
                label = { Text("Enter password") },
                visualTransformation =
                if (state.passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    IconButton(onClick = { event(SignupEvent.PasswordVisibility) }) {
                        val visibilityIcon =
                            if (state.passwordHidden) R.drawable.visibility else R.drawable.visibility_off
                        // Please provide localized description for accessibility services
                        val description = if (state.passwordHidden) "Show password" else "Hide password"
                        Icon(painter = painterResource(visibilityIcon), contentDescription = description)
                    }
                }
            )


//            TextField(
//                value = state.password,
//                onValueChange = { event(SignupEvent.SetPassword(it)) },
//                placeholder = { Text(text = "Password") },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(top = 12.dp),
//                shape = RoundedCornerShape(30.dp),
//                colors = TextFieldDefaults.textFieldColors(
//                    focusedTextColor = Color.Gray,
//                    disabledTextColor = Color.Transparent,
//                    focusedIndicatorColor = Color.Transparent,
//                    unfocusedIndicatorColor = Color.Transparent,
//                    disabledIndicatorColor = Color.Transparent
//                ),
//                visualTransformation = PasswordVisualTransformation(),
//                keyboardOptions = KeyboardOptions(
//                    // below line is used to specify our
//                    // type of keyboard such as text, number, phone.
//                    keyboardType = KeyboardType.Text,
//                    imeAction = ImeAction.Next
//                ),
//                singleLine = true
//            )

//            TextField(
//                value = state.confirmPassword,
//                onValueChange = { event(SignupEvent.SetConfirmPassword(it)) },
//                placeholder = { Text(text = "Confirm Password") },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(top = 12.dp),
//                shape = RoundedCornerShape(30.dp),
//                colors = TextFieldDefaults.textFieldColors(
//                    unfocusedTextColor = Color.Gray,
//                    disabledTextColor = Color.Transparent,
//                    focusedIndicatorColor = Color.Transparent,
//                    unfocusedIndicatorColor = Color.Transparent,
//                    disabledIndicatorColor = Color.Transparent
//                ),
//                visualTransformation = PasswordVisualTransformation(),
//                keyboardOptions = KeyboardOptions(
//                    // below line is used to specify our
//                    // type of keyboard such as text, number, phone.
//                    keyboardType = KeyboardType.Text,
//                    imeAction = ImeAction.Next
//                ),
//                singleLine = true
//            )


            TextField(
                value = state.confirmPassword,
                onValueChange = { event(SignupEvent.SetConfirmPassword(it)) },
                singleLine = true,
                label = { Text("Enter password") },
                visualTransformation =
                if (state.confirmPasswordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    IconButton(onClick = { event(SignupEvent.ConfirmPasswordVisibility) }) {
                        val visibilityIcon =
                            if (state.confirmPasswordHidden) R.drawable.visibility else R.drawable.visibility_off
                        // Please provide localized description for accessibility services
                        val description = if (state.confirmPasswordHidden) "Show password" else "Hide password"
                        Icon(painter = painterResource(visibilityIcon), contentDescription = description)
                    }
                }
            )

        }
        item {
            Button(
                onClick = {event(SignupEvent.Signup)}, modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp)), colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                )
            ) {
                Text(text = "SignUp")
            }

//        Text(text = "Or",color=Color.Gray,modifier=Modifier.padding(top=12.dp))

//        Button(onClick = {}, modifier = Modifier
//            .padding(top = 12.dp)
//            .fillMaxWidth()
//            ,
//            contentPadding = PaddingValues(6.dp),
//            shape= RoundedCornerShape(20.dp),
//            border = BorderStroke(2.dp, color = Color.Black)
//            , colors= ButtonDefaults.buttonColors(
//                containerColor = Color.White
//            ) ){
//            Text(text = "Sign in with google",color=Color.Black)



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
    }
}