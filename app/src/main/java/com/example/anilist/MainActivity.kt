package com.example.anilist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.anilist.Screens.Components.CardsTemp
import com.example.anilist.Screens.Components.Prev
import com.example.anilist.Screens.Components.list
import com.example.anilist.Screens.Screen.AnimeDetail
import com.example.anilist.Screens.Screen.MainScreen
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
                    //AnimeDetail()
                    //Prev()
                    MainScreen()
                }
            }
        }
    }
}