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
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.anilist.Screens.Components.CardAnime

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun List(){
    Scaffold(topBar = {
        TopAppBar() {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back",
                modifier = Modifier.clickable { })
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = "AniList",textAlign= TextAlign.Center,
                fontFamily = FontFamily.Serif,
                modifier = Modifier
                    .fillMaxWidth()
                    .width(30.dp)
                    .padding(top = 10.dp))

        }
    }){
        Content(lista)
    }
}
data class Lista(val Nombre:String, val Estreno:String,val Genero:String,val Imagen:String)
val lista = listOf <Lista> (
    Lista("Bleach","Primavera 2022","Shonen","bleach.jpg"),
    Lista("Bleach","Primavera 2022","Shonen","bleach.jpg"),
    Lista("Bleach","Primavera 2022","Shonen","bleach.jpg")
)
@Composable
fun Content(listanimes: List<Lista>){
    LazyColumn{
        items(listanimes){lista ->
        CardAnime(lista)
        }
    }
}

