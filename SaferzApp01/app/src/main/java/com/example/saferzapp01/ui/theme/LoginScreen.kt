@file:Suppress("DEPRECATION")

package com.example.instagramui.Safers

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.R
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun loginScreen(){
    var username by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }
        Column (modifier= Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .offset(y = -40.dp), verticalArrangement =Arrangement.Center
            , horizontalAlignment = Alignment.CenterHorizontally ) {
            Image(painter = painterResource(id =com.example.saferzapp01.R.drawable.sefarz_logo) , contentDescription ="logo"
                , contentScale = ContentScale.Crop , modifier = Modifier.size(200.dp))
            TextField(value = username, onValueChange = {username=it}, placeholder = { Text(text = "Email") },modifier= Modifier
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
            TextField(value = password, onValueChange = {password=it}, placeholder = { Text(text = "Password") },modifier= Modifier
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

            Button(onClick = {}, modifier = Modifier
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
fun signUp(){
    var username by remember { mutableStateOf(TextFieldValue()) }
    var email by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }
    var confirmPassword by remember { mutableStateOf(TextFieldValue()) }
    Column (modifier= Modifier
        .fillMaxSize()
        .padding(horizontal = 16.dp)
        .offset(y = -40.dp), verticalArrangement =Arrangement.Center
        , horizontalAlignment = Alignment.CenterHorizontally ) {
        Image(painter = painterResource(id =com.example.saferzapp01.R.drawable.sefarz_logo) , contentDescription ="logo"
            , contentScale = ContentScale.Crop , modifier = Modifier.fillMaxWidth())
        TextField(value = username, onValueChange = {username=it}, placeholder = { Text(text = "Username") },modifier= Modifier
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

        TextField(value = username, onValueChange = {username=it}, placeholder = { Text(text = "Email") },modifier= Modifier
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

        TextField(value = password, onValueChange = {password=it}, placeholder = { Text(text = "Password") },modifier= Modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
            ,shape= RoundedCornerShape(30.dp),
            colors = TextFieldDefaults.textFieldColors(
                focusedTextColor = Color.Gray,
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            visualTransformation = PasswordVisualTransformation()
            , keyboardOptions =  KeyboardOptions(
                // below line is used to specify our
                // type of keyboard such as text, number, phone.
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
            , singleLine = true
        )

        TextField(value = password, onValueChange = {password=it}, placeholder = { Text(text = "Confirm Password") },modifier= Modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
            ,shape= RoundedCornerShape(30.dp),
            colors = TextFieldDefaults.textFieldColors(
                unfocusedTextColor = Color.Gray,
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            visualTransformation = PasswordVisualTransformation()
            , keyboardOptions =  KeyboardOptions(
                // below line is used to specify our
                // type of keyboard such as text, number, phone.
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
            , singleLine = true
        )


        Button(onClick = {}, modifier = Modifier
            .padding(top = 12.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            , colors= ButtonDefaults.buttonColors(
                containerColor = Color.Black
            ) ){
            Text(text = "SignUp")
        }

        Text(text = "Or",color=Color.Gray,modifier=Modifier.padding(top=12.dp))

        Button(onClick = {}, modifier = Modifier
            .padding(top = 12.dp)
            .fillMaxWidth()
            ,
            contentPadding = PaddingValues(6.dp),
            shape= RoundedCornerShape(20.dp),
            border = BorderStroke(2.dp, color = Color.Black)
            , colors= ButtonDefaults.buttonColors(
                containerColor = Color.White
            ) ){
            Text(text = "Sign in with google",color=Color.Black)
        }


        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
            , horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically){
            Text(text = "Already have an account?  ",color = Color.Black,
                fontSize = 10.sp,
                fontWeight = FontWeight.Light,
                textDecoration = TextDecoration.None)

            Text(text = "Login", color = Color.Black,
                fontSize = 10.sp,
                fontWeight = FontWeight.SemiBold,
                textDecoration = TextDecoration.None)
        }
    }
}