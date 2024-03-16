package com.example.saferzapp01.Views.MainScreen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.saferzapp01.navigation.BottomBarScreenRoutes
import com.example.saferzapp01.navigation.graph.homeNavGraph
import com.example.saferzapp01.navigation.GraphRoutes


fun NavGraphBuilder.homeScreen() {
    composable(GraphRoutes.MainGraph.route) {
        val navController =rememberNavController()
        Scaffold(
            bottomBar = { BottomBar(navController = navController) }
        ) { padding ->
            Column(modifier = Modifier.padding(padding)) {
                Log.d("home", "df")
                homeNavGraph(navController)
            }
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreenRoutes.Home,
        BottomBarScreenRoutes.Profile,
        BottomBarScreenRoutes.Settings,
    )
    val navBackStackEntry by
    navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = screens.any { it.route == currentDestination?.route }
    if (bottomBarDestination) {
        NavigationBar {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreenRoutes,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected=currentDestination?.hierarchy?.any {
        it.route == screen.route
    } == true
    NavigationBarItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(
                imageVector = if(selected) screen.selectedIcon 
                else screen.unselectedIcon,
                contentDescription = "Navigation Icon"
            )
        },
        selected = selected,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}