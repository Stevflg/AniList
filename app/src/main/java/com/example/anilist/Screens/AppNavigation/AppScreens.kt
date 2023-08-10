package com.example.anilist.Screens.AppNavigation

sealed class AppScreens (val route: String){
object MainScreen: AppScreens("mainscreen")
object List: AppScreens("list")
object AnimeDetail: AppScreens("animedetail")
object Temporadas: AppScreens("temporadas")
}