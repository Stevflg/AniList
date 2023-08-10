package com.example.anilist.Screens.AppNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.anilist.Screens.Components.CardTemp
import com.example.anilist.Screens.Screen.AnimeDetail
import com.example.anilist.Screens.Screen.MainScreen
import com.example.anilist.Screens.Screen.List
import com.example.anilist.Screens.Components.CardsTemp

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "mainscreen"){
        composable(route = AppScreens.MainScreen.route){
            MainScreen(navController = navController)
        }
        composable(route = AppScreens.List.route){
          List(navController = navController)
        }
        composable(route = AppScreens.AnimeDetail.route+"/{idAnime}",
            arguments = listOf(
                navArgument("idAnime"){type = NavType.StringType}
            )){
            AnimeDetail(navController = navController, idAnime = it.arguments?.getString("idAnime")!!)
        }
        composable(route = AppScreens.Temporadas.route+"/{idAnime}",
        arguments = listOf(navArgument("idAnime"){type = NavType.StringType})){
            CardsTemp(
                navController = navController,
                it.arguments?.getString("idAnime")!!
            )
        }

    }
}
