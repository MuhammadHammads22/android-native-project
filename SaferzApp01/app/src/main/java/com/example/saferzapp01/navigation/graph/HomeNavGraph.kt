package com.example.saferzapp01.navigation.graph

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.saferzapp01.navigation.GraphRoutes
import com.example.saferzapp01.navigation.ScreenRoute

@Composable
fun homeNavGraph(navController:NavHostController){
    NavHost(navController=navController,startDestination =ScreenRoute.Home.route , route = GraphRoutes.MainGraph.route){
        composable(ScreenRoute.Home.route){
            Box(modifier=Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Home")
            }
        }
        composable(ScreenRoute.Profile.route){
            Box(modifier=Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "chat list")
            }
        }
        composable(ScreenRoute.Setting.route){
            Box(modifier=Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "profile")
            }
        }
    }
}