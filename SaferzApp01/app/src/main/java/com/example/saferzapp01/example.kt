//package com.example.saferzapp01
//
//NavHost(navController, startDestination = "title_screen") {
//    composable("title_screen") {
//        TitleScreen(
//            onPlayClicked = { navController.navigate("register") },
//            onLeaderboardsClicked = { /* Navigate to leaderboards */ }
//        )
//    }
//    composable("register") {
//        RegisterScreen(
//            onSignUpComplete = { navController.navigate("gameInProgress") }
//        )
//    }
//    navigation(startDestination = "match", route = "gameInProgress") {
//        composable("match") {
//            MatchScreen(
//                onStartGame = { navController.navigate("in_game") }
//            )
//        }
//        composable("in_game") {
//            InGameScreen(
//                onGameWin = { navController.navigate("results_winner") },
//                onGameLose = { navController.navigate("game_over") }
//            )
//        }
//        composable("results_winner") {
//            ResultsWinnerScreen(
//                onNextMatchClicked = {
//                    navController.navigate("match") {
//                        popUpTo("match") { inclusive = true }
//                    }
//                },
//                onLeaderboardsClicked = { /* Navigate to leaderboards */ }
//            )
//        }
//        composable("game_over") {
//            GameOverScreen(
//                onTryAgainClicked = {
//                    navController.navigate("match") {
//                        popUpTo("match") { inclusive = true }
//                    }
//                }
//            )
//        }
//    }
//}




//fun NavGraphBuilder.addNestedGraph(navController: NavController) {
//    navigation(startDestination = "match", route = "gameInProgress") {
//        composable("match") {
//            MatchScreen(
//                onStartGame = { navController.navigate("in_game") }
//            )
//        }
//        composable("in_game") {
//            InGameScreen(
//                onGameWin = { navController.navigate("results_winner") },
//                onGameLose = { navController.navigate("game_over") }
//            )
//        }
//        composable("results_winner") {
//            ResultsWinnerScreen(
//                onNextMatchClicked = { navController.navigate("match") },
//                onLeaderboardsClicked = { /* Navigate to leaderboards */ }
//            )
//        }
//        composable("game_over") {
//            GameOverScreen(
//                onTryAgainClicked = { navController.navigate("match") }
//            )
//        }
//    }
//}






//@Composable
//fun MyApp() {
//    val navController = rememberNavController()
//    NavHost(navController, startDestination = "title_screen") {
//        composable("title_screen") {
//            TitleScreen(
//                onPlayClicked = { navController.navigate("register") },
//                onLeaderboardsClicked = { /* Navigate to leaderboards */ }
//            )
//        }
//        composable("register") {
//            RegisterScreen(
//                onSignUpComplete = { navController.navigate("gameInProgress") }
//            )
//        }
//
//        // Add the nested graph using the extension function
//        addNestedGraph(navController)
//    }
//}


//////////////////////////using dialog in navigation
//
//@Composable
//fun SettingsDialog(){
//    Text("Settings")
//    // ...
//}
//
//@Composable
//fun MyApp() {
//    val navController = rememberNavController()
//    NavHost(navController, startDestination = "home") {
//        composable("home") { Home(onNavigateToHome = { navController.navigate("home") }) }
//        dialog("settings") { SettingsDialog(onNavigateToSettingsDialog = { navController.navigate("settings") }) }
//    }
//}


//val customNavigator = CustomNavigator()
//