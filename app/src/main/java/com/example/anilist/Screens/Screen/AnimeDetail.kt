package com.example.anilist.Screens.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.anilist.Screens.Components.CardTemp
import com.example.anilist.Screens.Components.CardsTemp
import com.example.anilist.Screens.Components.list

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AnimeDetail(){
Scaffold(topBar = {
    TopAppBar() {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back",
            modifier = Modifier.clickable { })
        Spacer(modifier = Modifier.size(135.dp))
        Text("AniList",textAlign= TextAlign.Start,
            fontWeight = FontWeight.Bold, color = MaterialTheme.colors.onSecondary,
            style = TextStyle(fontSize = 25.sp),
            modifier = Modifier
                .fillMaxWidth()
                .width(20.dp))
    }
}) {
        ContentDetail()
}
}
@Composable
fun ContentDetail(){
Column(horizontalAlignment = Alignment.CenterHorizontally,
modifier = Modifier
    .verticalScroll(rememberScrollState())
    .fillMaxSize()
    .fillMaxHeight()
    .padding(start = 20.dp, end = 20.dp)) {
    Spacer(modifier = Modifier.size(20.dp))
    Text("Shingeki no kiojin", style = TextStyle(fontSize = 23.sp),
        fontWeight = FontWeight.Bold, color = MaterialTheme.colors.primary,
        textAlign = TextAlign.Center,
        modifier=Modifier.padding(start = 50.dp, end = 50.dp))

    Box(modifier = Modifier
        .width(200.dp)
        .height(290.dp))
    {
        AsyncImage(model = "https://pm1.narvii.com/6571/5109c140269cef1eddf6301575dfe133fe1d2d51_hq.jpg",
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
        Text("Primavera 2022",style = TextStyle(fontSize = 17.sp)
            , color = MaterialTheme.colors.primary)
    }
    Spacer(modifier = Modifier.size(5.dp))
    Row(horizontalArrangement = Arrangement.Start,
        modifier = Modifier.fillMaxWidth()){
        Text("Genero(s):  ", style = TextStyle(fontSize = 17.sp),
            fontWeight = FontWeight.Bold, color = MaterialTheme.colors.primary)
        Text("Shonen",style = TextStyle(fontSize = 17.sp)
            , color = MaterialTheme.colors.primary)
    }

    Spacer(modifier = Modifier.size(10.dp))
    Text("Descripcion", textDecoration = TextDecoration.Underline ,style = TextStyle(fontSize = 17.sp),
        fontWeight = FontWeight.Bold, color = MaterialTheme.colors.primary)

    Spacer(modifier = Modifier.size(5.dp))
    Text("Han Pasado Cuatro Años desde que el regimiento scout llego" +
            "a la costa, y el mundo se ve diferente ahora. las cosas se estan " +
            "calentando a medida que el destino del regimiento scout ...",style = TextStyle(fontSize = 17.sp)
        , color = MaterialTheme.colors.primary,
    textAlign = TextAlign.Justify)

    Spacer(modifier = Modifier.size(10.dp))
    Text("Temporadas", textDecoration = TextDecoration.Underline ,style = TextStyle(fontSize = 17.sp),
        fontWeight = FontWeight.Bold, color = MaterialTheme.colors.primary)
    Spacer(modifier = Modifier.size(5.dp))
    CardsTemp(list)
    Spacer(modifier = Modifier.size(20.dp))
}
}
@Preview(showSystemUi = true)
@Composable
fun prevAnimeDetail(){
    AnimeDetail()
}