package com.example.anilist.Screens.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.anilist.Data.Entities.Anime
import com.example.anilist.Data.ServicesApi.ApiClient
import com.example.anilist.Screens.Components.CardAnime
import com.example.anilist.Screens.Components.LoadingScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun List(navController: NavController){
    Scaffold(topBar = {
        TopAppBar() {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back",
                modifier = Modifier.clickable {navController.popBackStack()})
            Text("AniList",textAlign= TextAlign.Center,
                fontWeight = FontWeight.Bold, color = MaterialTheme.colors.onSecondary,
                style = TextStyle(fontSize = 25.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .width(20.dp))
        }
    }){
        var isLoading by remember { mutableStateOf(true) }
        val animestate = remember{ mutableStateOf<List<Anime>>(emptyList()) }
        LaunchedEffect(Unit){
            isLoading = true
            val animes= fetchAnime()
            animestate.value = animes
            isLoading = false
        }
        if(isLoading){
            LoadingScreen()
        }
        else{
            Content(navController,animestate.value)
        }
    }
}

@Composable
fun Content(navController: NavController,listanimes: List<Anime>){
    LazyColumn{
            items(listanimes){ lista ->
                CardAnime(navController,lista)
            }
    }
}

suspend fun fetchAnime():List<Anime>{
    return withContext(Dispatchers.IO){
        try {
            val response = ApiClient.apiService.getAnimes()
            response
        }catch (e:Exception){
            emptyList()
        }
    }
}



