package com.example.saferzapp01.navigation.graph


import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.Safers.LoginScreen
import com.example.saferzapp01.navigation.GraphRoutes
import com.example.saferzapp01.navigation.ScreenRoute
import com.example.saferzapp01.ViewModel.ForgotPasswordViewModel
import com.example.saferzapp01.ViewModel.LoginViewModel
import com.example.saferzapp01.Views.ForgotPassword
import com.example.saferzapp01.Views.SignupScreen
import com.example.saferzapp01.Views.termsAndCondition
import com.example.saferzapp01.ViewModel.SignupViewModel


fun NavGraphBuilder.CreateAuthGraph(navController: NavHostController){
    navigation(
        startDestination = ScreenRoute.Signup.route,
        route = GraphRoutes.AuthGraph.route
    ){
        composable(ScreenRoute.Signup.route){
            val viewModel: SignupViewModel = hiltViewModel()
            val state by viewModel.signupState.collectAsState()

            SignupScreen(state,viewModel::onSignupEvent, navigateToLogin ={navController.navigateToLogin()})
        }
        composable(ScreenRoute.Login.route){
            val viewmodel: LoginViewModel = hiltViewModel()
            val state by viewmodel.loginState.collectAsState()
            LoginScreen(state = state, event = viewmodel::onLoginEvent, navigateToForgotPassword = {navController.navigateToForgotPassword()}, navigateToMainGraph = {navController.navigateToMainGraph()}, navigateToSignup = {navController.navigateToSignup() }, navigateToTermsAndCondition = {navController.navigateToTermsAndCondition() })
        }
        composable(ScreenRoute.ForgotPassword.route){
            val viewmodel: ForgotPasswordViewModel = hiltViewModel()
            val state by viewmodel.forgotPasswordState.collectAsState()
            ForgotPassword(state =state , event = viewmodel::onResetPasswordEvent)
        }
        composable(ScreenRoute.TermsCondition.route){
           termsAndCondition()
        }
    }
}
fun NavController.navigateToLogin(){
    this.navigate(ScreenRoute.Login.route)
}
fun NavController.navigateToForgotPassword(){
    this.navigate(ScreenRoute.ForgotPassword.route)
}
fun NavController.navigateToMainGraph(){
    this.navigate(GraphRoutes.MainGraph.route){
        popBackStack(ScreenRoute.Signup.route,true)
    }
}
fun NavController.navigateToSignup(){
    this.navigate(ScreenRoute.Signup.route)
}
fun NavController.navigateToTermsAndCondition(){
    this.navigate(ScreenRoute.TermsCondition.route)
}