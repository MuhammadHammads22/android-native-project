package com.example.saferzapp01.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector


sealed class BottomBarScreenRoutes(
    val route: String,
    val title: String,
    val unselectedIcon: ImageVector,
    val selectedIcon:ImageVector
) {

    object Home : BottomBarScreenRoutes(
        route = ScreenRoute.Home.route,
        title = "HOME",
        unselectedIcon = Icons.Outlined.Home,
        selectedIcon = Icons.Filled.Home
    )

    object Profile : BottomBarScreenRoutes(
        route = ScreenRoute.Profile.route,
        title = "PROFILE",
        unselectedIcon = Icons.Outlined.Home,
        selectedIcon = Icons.Filled.Home
    )

    object Settings : BottomBarScreenRoutes(
        route = ScreenRoute.Setting.route,
        title = "SETTINGS",
        unselectedIcon = Icons.Outlined.Home,
        selectedIcon = Icons.Filled.Home
    )
}

