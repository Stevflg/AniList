package com.example.anilist.Screens.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.anilist.Data.Entities.Anime
import com.example.anilist.Screens.AppNavigation.AppScreens
@Composable
fun CardAnime(navController: NavController,listanime: Anime) {
    val anid= remember {mutableStateOf(listanime.Id) }
    Row(horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .padding(start = 10.dp, top = 5.dp, end = 10.dp, bottom = 5.dp)
            .clip(RoundedCornerShape(10))
            .background(color = MaterialTheme.colors.background)
            .clickable(onClick = {
                navController.navigate(AppScreens.AnimeDetail.route + "/${anid.value}")
            }) ){
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