package com.example.saferzapp01.navigation

sealed class GraphRoutes(
    val route:String,
    val title:String?=null
) {

    object AuthGraph:GraphRoutes(authGraph)
    object MainGraph:GraphRoutes(mainGraph)

}
const val authGraph="auth_graph"
const val mainGraph="main_graph"