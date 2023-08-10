package com.example.anilist.Screens.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.anilist.Data.Entities.AnimeDetail
import com.example.anilist.Data.Entities.Temps
import com.example.anilist.Data.ServicesApi.ApiClient
import com.example.anilist.Screens.Components.CardsTemp
import com.example.anilist.Screens.Components.LoadingScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AnimeDetail(navController: NavController,idAnime: String){
Scaffold(topBar = {
    TopAppBar() {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back",
            modifier = Modifier.clickable {navController.popBackStack() })
        Spacer(modifier = Modifier.size(135.dp))
        Text("AniList",textAlign= TextAlign.Start,
            fontWeight = FontWeight.Bold, color = MaterialTheme.colors.onSecondary,
            style = TextStyle(fontSize = 25.sp),
            modifier = Modifier
                .fillMaxWidth()
                .width(20.dp))
    }
}) {
    var isLoading by remember { mutableStateOf(true) }
    val animeDetail = remember{ mutableStateOf<List<AnimeDetail>>(emptyList()) }
    LaunchedEffect(Unit){
        isLoading = true
        val animestate= fetchAnimeDetail()
        animeDetail.value = animestate
        getImage(idAnime)
        isLoading = false
    }
    if(isLoading){
        LoadingScreen()
    }
    else{
            ContentDetail(navController,animeDetail.value, idAnime)
    }
}
}
var Imagen_: String = ""

@Composable
fun ContentDetail(navController: NavController,detail:List<AnimeDetail>,AnimeId: String){
    val id by remember {mutableStateOf(AnimeId)}
    val animeDetail: AnimeDetail? =detail.find { it.IdAnime == id}
Column(horizontalAlignment = Alignment.CenterHorizontally,
modifier = Modifier
    .verticalScroll(rememberScrollState())
    .fillMaxSize()
    .fillMaxHeight()
    .padding(start = 20.dp, end = 20.dp)) {
    Spacer(modifier = Modifier.size(20.dp))
    animeDetail?.Nombre?.let {
        Text(
            it, style = TextStyle(fontSize = 23.sp),
        fontWeight = FontWeight.Bold, color = MaterialTheme.colors.primary,
        textAlign = TextAlign.Center,
        modifier=Modifier.padding(start = 50.dp, end = 50.dp))
    }

    Box(modifier = Modifier
        .width(200.dp)
        .height(290.dp))
    {
        AsyncImage(Imagen_ ,
            contentScale = ContentScale.Crop,
            contentDescription = "Portada",
            modifier = Modifier
                .clip(RoundedCornerShape(20))
                .width(200.dp)
                .height(270.dp)
                .align(Alignment.Center))
    }
    Row(horizontalArrangement = Arrangement.Start,
        modifier = Modifier.fillMaxWidth()){
        Text("Estreno :     ", style = TextStyle(fontSize = 17.sp),
            fontWeight = FontWeight.Bold, color = MaterialTheme.colors.primary)
        animeDetail?.Estreno?.let {
            Text(
                it,style = TextStyle(fontSize = 17.sp), color = MaterialTheme.colors.primary)
        }
    }
    Spacer(modifier = Modifier.size(5.dp))
    Row(horizontalArrangement = Arrangement.Start,
        modifier = Modifier.fillMaxWidth()){
        Text("Genero(s):  ", style = TextStyle(fontSize = 17.sp),
            fontWeight = FontWeight.Bold, color = MaterialTheme.colors.primary)
        val generos = StringBuilder()
        animeDetail?.Generos?.forEach { generos.append(it).append(", ") }
        val gen=generos.dropLast(2).toString()
        Text(gen,style = TextStyle(fontSize = 17.sp)
            , color = MaterialTheme.colors.primary)
    }

    Spacer(modifier = Modifier.size(10.dp))
    Text("Descripcion", textDecoration = TextDecoration.Underline ,style = TextStyle(fontSize = 17.sp),
        fontWeight = FontWeight.Bold, color = MaterialTheme.colors.primary)

    Spacer(modifier = Modifier.size(5.dp))
    animeDetail?.Descripcion?.let {
        Text(
            it,style = TextStyle(fontSize = 17.sp)
        , color = MaterialTheme.colors.primary,
            textAlign = TextAlign.Justify)
    }

    Spacer(modifier = Modifier.size(10.dp))
    Text("Temporadas", textDecoration = TextDecoration.Underline ,style = TextStyle(fontSize = 17.sp),
        fontWeight = FontWeight.Bold, color = MaterialTheme.colors.primary)
    Spacer(modifier = Modifier.size(5.dp))
    CardsTemp(navController,id)
    Spacer(modifier = Modifier.size(20.dp))
}
}

suspend fun fetchAnimeDetail():List<AnimeDetail>{
    return withContext(Dispatchers.IO){
        try {
            val response = ApiClient.apiService.getDetails("anime/detail/")
            return@withContext response
        }catch (e:Exception){
            emptyList()
        }
    }
}

suspend fun getImage(idAnime: String){
    return withContext(Dispatchers.IO){
        try {
            val response = ApiClient.apiService.getAnimes()
            val listanim = response.find { it.Id == idAnime }?.Imagen
            Imagen_ = listanim.toString()
        }catch (e:Exception){
            Imagen_=" "
        }
    }
}