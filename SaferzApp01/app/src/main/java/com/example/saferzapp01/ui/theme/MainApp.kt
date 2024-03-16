
package com.example.saferzapp01.ui.theme

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.saferzapp01.Views.MainScreen.homeScreen
import com.example.saferzapp01.navigation.GraphRoutes
import com.example.saferzapp01.navigation.graph.CreateAuthGraph

//import com.example.saferzapp01.navigation.graph.CreateAuthGraph

//import com.example.saferzapp01.navigation.GraphRoutes
//import com.example.saferzapp01.Views.MainScreen.homeScreen


@Composable
fun MainApp() {
    val navController:NavHostController = rememberNavController()

   NavHost(navController = navController, startDestination = GraphRoutes.AuthGraph.route){
       Log.d("viewmodel","main")

      this.CreateAuthGraph(navController)
      this.homeScreen()
   }

}