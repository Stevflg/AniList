package com.example.anilist.Screens.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.anilist.R
import com.example.anilist.Screens.Screen.Lista

@Composable
fun CardAnime(listanime: Lista ) {
Row(horizontalArrangement =Arrangement.Start,
    modifier = Modifier
        .padding(start = 10.dp, top = 5.dp ,end = 10.dp, bottom = 5.dp)
        .clip(RoundedCornerShape(10))
        .background(color = MaterialTheme.colors.background)
        .clickable { }){
    Box(modifier = Modifier.padding(top = 5.dp, bottom = 5.dp, start = 8.dp)) {
        AsyncImage(model = listanime.Imagen,
            contentDescription = "Portada",
            contentScale = ContentScale.Crop,
        modifier = Modifier
            .height(110.dp)
            .width(80.dp)
            .clip(RoundedCornerShape(20)))
    }
    Spacer(modifier=Modifier.size(20.dp))
    Row(horizontalArrangement = Arrangement.Center,
    modifier = Modifier.fillMaxWidth()){
        Column() {
            Row(horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()){
                Text(listanime.Nombre, style = TextStyle(fontSize = 20.sp),
                fontWeight = FontWeight.Bold, color = MaterialTheme.colors.primary)
            }
            Spacer(modifier = Modifier.size(20.dp))
            Row(horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth()){
                Text("Estreno : ", style = TextStyle(fontSize = 15.sp),
                    fontWeight = FontWeight.Bold, color = MaterialTheme.colors.primary)
                Text(listanime.Estreno,style = TextStyle(fontSize = 15.sp)
                    , color = MaterialTheme.colors.primary)
            }
            Spacer(modifier = Modifier.size(10.dp))
            Row(horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth()){
                Text("Genero :  ", style = TextStyle(fontSize = 15.sp),
                    fontWeight = FontWeight.Bold, color = MaterialTheme.colors.primary)
                Text(listanime.Genero,style = TextStyle(fontSize = 15.sp)
                    , color = MaterialTheme.colors.primary)
            }
        }
    }
    }
}