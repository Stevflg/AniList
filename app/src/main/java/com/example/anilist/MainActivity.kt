package com.example.anilist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.anilist.Screens.AppNavigation.AppNavigation
import com.example.anilist.Screens.Screen.MediaPlayer
import com.example.anilist.ui.theme.AniListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AniListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.surface

                ) {
                    //MediaPlayer()
                    AppNavigation()
                    //AnimeDetail()
                    //Prev()
                    //MainScreen()
                    //com.example.anilist.Screens.Screen.List()
                    //CardsTemp("64b4a10857112db61a5290ed")
                }
            }
        }
    }
}