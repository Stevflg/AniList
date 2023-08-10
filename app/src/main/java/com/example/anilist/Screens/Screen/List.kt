package com.example.anilist.Screens.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.anilist.Data.Entities.Anime
import com.example.anilist.Data.ServicesApi.ApiClient
import com.example.anilist.Screens.AppNavigation.AppScreens
import com.example.anilist.Screens.Components.LoadingScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun List(navController: NavController){
    Scaffold(topBar = {
        TopAppBar() {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back",
                modifier = Modifier.clickable { })
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
@Composable
fun CardAnime(navController: NavController,listanime: Anime) {
    val id = remember{mutableStateOf(listanime.Id)}
    val  imagen = remember{mutableStateOf(listanime.Imagen)}
    Row(horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .padding(start = 10.dp, top = 5.dp, end = 10.dp, bottom = 5.dp)
            .clip(RoundedCornerShape(10))
            .background(color = MaterialTheme.colors.background)
            .clickable(onClick = { navController.navigate(AppScreens.AnimeDetail.route + "/$id/$imagen") }) ){
        Box(modifier = Modifier.padding(top = 5.dp, bottom = 5.dp, start = 8.dp)) {
            AsyncImage(model = listanime.Imagen,
                contentDescription = "Portada",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(110.dp)
                    .width(80.dp)
                    .clip(RoundedCornerShape(20)))
        }
        Spacer(modifier=Modifier.size(10.dp))
        Row(horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ){
            Column() {
                Row(horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()){
                    Text(listanime.Nombre, style = TextStyle(fontSize = 20.sp),
                        fontWeight = FontWeight.Bold, color = MaterialTheme.colors.primary)
                }
                Spacer(modifier = Modifier.size(5.dp))
                Row(horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth()){
                    Text("Estreno : ", style = TextStyle(fontSize = 15.sp),
                        fontWeight = FontWeight.Bold, color = MaterialTheme.colors.primary)
                    Text(listanime.Estreno,style = TextStyle(fontSize = 15.sp)
                        , color = MaterialTheme.colors.primary)
                }

                Row(horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 5.dp)){
                    Text("Genero :  ", style = TextStyle(fontSize = 15.sp),
                        fontWeight = FontWeight.Bold, color = MaterialTheme.colors.primary)
                    val generos = StringBuilder()
                    listanime.Generos.forEach {
                        generos.append("$it, ")
                    }
                    val gen=generos.dropLast(2).toString()
                    Text(gen,style = TextStyle(fontSize = 15.sp)
                        , color = MaterialTheme.colors.primary)
                }
            }
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


