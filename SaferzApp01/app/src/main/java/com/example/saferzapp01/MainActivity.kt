package com.example.saferzapp01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.Safers.loginScreen
import com.example.Safers.signUp
import com.example.saferzapp01.Events.SignupEvent
import com.example.saferzapp01.ui.theme.SaferzApp01Theme
import com.example.saferzmobileapp.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewmodel: MainViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.actionBar?.hide()
        installSplashScreen().apply {
            setKeepOnScreenCondition { viewmodel.loading.value }
        }
        setContent {
            val signupState by viewmodel.signupState.collectAsState()
            val loginState by viewmodel.loginState.collectAsState()
            SaferzApp01Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

//                    val noOfCore=3
//                    var list = mutableListOf<Double>(1.0,2.0,4.0,53.0,12.0,23.0,11.0,51.0)
//                    var i=list.size/noOfCore
//                    for(i in 0..i){
//                        doSum()
//                }
                    signUp(state = signupState, event = viewmodel::onSignupEvent)


//                  loginScreen(loginState,viewmodel::onLoginEvent)


                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    SaferzApp01Theme {

    }
}
fun doSum(n1:Double,n2:Double):Double {
    return n1+n2

}

