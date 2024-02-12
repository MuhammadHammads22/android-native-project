package com.example.saferzapp01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.instagramui.Safers.loginScreen
import com.example.instagramui.Safers.signUp
import com.example.saferzapp01.ui.theme.SaferzApp01Theme
import com.example.saferzmobileapp.MainViewModel

class MainActivity : ComponentActivity() {
    val viewmodel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.actionBar?.hide()
        installSplashScreen().apply {
            setKeepOnScreenCondition{viewmodel.loading.value}
        }
        setContent {
            SaferzApp01Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                    Greeting("Android")
//                    loginScreen()
                    signUp()
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SaferzApp01Theme {
//        Greeting("Android")
    loginScreen()
    }
}