package com.example.saferzapp01.navigation

import androidx.compose.ui.graphics.vector.ImageVector

sealed class ScreenRoute (
        val route: String,
        val title: String? = null,
        val icon:ImageVector?=null,
        val selectedIcon:ImageVector?=null
    ) {

        object Signup : ScreenRoute(navigationRouteOnSignup)
        object Login: ScreenRoute(navigationRouteLogin)
        object ForgotPassword : ScreenRoute(navigationRouteForgotPassword)
        object TermsCondition : ScreenRoute(navigationRouteTermsCondition)

        object Home : ScreenRoute(navigationRouteHome)
        object Profile : ScreenRoute(navigationRouteChatList)
        object Setting: ScreenRoute(navigationRouteSetting)
    }

    const val navigationRouteOnSignup = "signup"
    const val navigationRouteLogin = "login"
    const val navigationRouteForgotPassword = "forgot_password"
    const val navigationRouteTermsCondition = "terms_condtion"

    const val navigationRouteHome = "home"
    const val navigationRouteChatList = "chat_list"
    const val navigationRouteSetting = "setting"


