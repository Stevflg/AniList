package com.example.anilist.Screens.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.anilist.Data.Entities.Temps
import com.example.anilist.Data.ServicesApi.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun CardsTemp(navController: NavController,idAnime: String){
    var isLoading by remember { mutableStateOf(true) }
    var listTemp = remember { mutableStateOf<List<Temps>>(emptyList()) }
    LaunchedEffect(Unit){
        isLoading = true
        val tempState = fetchTemps(idAnime)
        listTemp.value = tempState
        isLoading = false
    }
    if(isLoading){
        LoadingScreen()
    }
    else{
        LazyRow(modifier = Modifier
            .height(170.dp)
            .padding(top = 20.dp, start = 10.dp, end = 10.dp)
            .background(color = MaterialTheme.colors.background),
            horizontalArrangement = Arrangement.Center){
            items(listTemp.value){ temps ->
                    CardTemp(temps)
            }
        }
    }
}
@Composable
fun CardTemp(temps: Temps){
    Column (modifier = Modifier
        .clickable { }
        .padding(start = 5.dp, end = 5.dp, top = 5.dp, bottom = 5.dp)){
        Box(modifier = Modifier
            .width(90.dp)
            .height(120.dp))
        {
            AsyncImage(model = temps.Imagen, contentScale = ContentScale.Crop,contentDescription = "Portada", modifier = Modifier
                .clip(RoundedCornerShape(20))
                .height(120.dp)
                .width(80.dp)
                .align(Alignment.Center))
        }

        Text(text = "Temp "+ temps.Numero,color = MaterialTheme.colors.primary,
        modifier = Modifier.align(Alignment.CenterHorizontally), fontWeight = FontWeight.Bold)
    }

}

suspend fun fetchTemps(idAnime: String):List<Temps>{
    return withContext(Dispatchers.IO){
        try {
            val response = ApiClient.apiService.getTemporadas("anime/season/")
            val listTemp = response.find { it.IdAnime == idAnime }?.Temporadas
            return@withContext listTemp ?: emptyList()
        }catch (e:Exception){
            emptyList()
        }
    }
}