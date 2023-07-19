package com.example.anilist.Screens.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.anilist.Screens.Components.CardAnime

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun List(){
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
    }){
        Content(lista)
    }
}
data class Lista(val Nombre:String, val Estreno:String,val Genero:String,val Imagen:String)
val lista = listOf <Lista> (
    Lista("Shingeki no kiojin","Primavera 2022","Shonen","https://pm1.narvii.com/6571/5109c140269cef1eddf6301575dfe133fe1d2d51_hq.jpg"),
    Lista("Shingeki no kiojin","Primavera 2022","Shonen","https://pm1.narvii.com/6571/5109c140269cef1eddf6301575dfe133fe1d2d51_hq.jpg"),
    Lista("Shingeki no kiojin","Primavera 2022","Shonen","https://pm1.narvii.com/6571/5109c140269cef1eddf6301575dfe133fe1d2d51_hq.jpg"),
    Lista("Shingeki no kiojin","Primavera 2022","Shonen","https://pm1.narvii.com/6571/5109c140269cef1eddf6301575dfe133fe1d2d51_hq.jpg"),
    Lista("Shingeki no kiojin","Primavera 2022","Shonen","https://pm1.narvii.com/6571/5109c140269cef1eddf6301575dfe133fe1d2d51_hq.jpg"),
    Lista("Shingeki no kiojin","Primavera 2022","Shonen","https://pm1.narvii.com/6571/5109c140269cef1eddf6301575dfe133fe1d2d51_hq.jpg"),
    Lista("Shingeki no kiojin","Primavera 2022","Shonen","https://pm1.narvii.com/6571/5109c140269cef1eddf6301575dfe133fe1d2d51_hq.jpg"),
    Lista("Shingeki no kiojin","Primavera 2022","Shonen","https://pm1.narvii.com/6571/5109c140269cef1eddf6301575dfe133fe1d2d51_hq.jpg"),
    Lista("Shingeki no kiojin","Primavera 2022","Shonen","https://pm1.narvii.com/6571/5109c140269cef1eddf6301575dfe133fe1d2d51_hq.jpg")

)
@Composable
fun Content(listanimes: List<Lista>){
    LazyColumn{
        items(listanimes){lista ->
        CardAnime(lista)
        }
    }
}

