package com.example.anilist.Screens.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.anilist.R

@Composable
fun CardsTemp(Temps: List<Temps>){
    LazyRow(modifier = Modifier
        .height(170.dp)
        .padding(top = 20.dp, start = 10.dp, end = 10.dp)
        .background(color = MaterialTheme.colors.background),
        horizontalArrangement = Arrangement.Center){
        items(Temps){
                listemps->CardTemp(listemps)
        }
    }
}
@Composable
fun CardTemp(temps: Temps){
    Column (modifier = Modifier
        .clickable { }
        .padding(start = 5.dp, end = 5.dp,top=5.dp, bottom = 5.dp)){
        Box(modifier = Modifier
            .width(90.dp)
            .height(120.dp))
        {
            AsyncImage(model = temps.image, contentScale = ContentScale.Crop,contentDescription = "Portada", modifier = Modifier
                .clip(RoundedCornerShape(20))
                .height(120.dp)
                .width(80.dp)
                .align(Alignment.Center))
        }/*Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "Portada",
        modifier = Modifier.align(Alignment.CenterHorizontally))*/

        Text(text = "Temp "+ temps.temp,color = MaterialTheme.colors.primary,
        modifier = Modifier.align(Alignment.CenterHorizontally), fontWeight = FontWeight.Bold)
    }

}
data class Temps(val temp: String, val image: String)
val list = listOf<Temps>(
    Temps("1","https://i.pinimg.com/originals/d1/fe/cb/d1fecbe74fb406e1d4e53cc2a666d33c.jpg"),
    Temps("2","https://i.pinimg.com/originals/d1/fe/cb/d1fecbe74fb406e1d4e53cc2a666d33c.jpg"),
    Temps("3","https://i.pinimg.com/originals/d1/fe/cb/d1fecbe74fb406e1d4e53cc2a666d33c.jpg"),
    Temps("4","https://i.pinimg.com/originals/d1/fe/cb/d1fecbe74fb406e1d4e53cc2a666d33c.jpg"),
    Temps("5","https://i.pinimg.com/originals/d1/fe/cb/d1fecbe74fb406e1d4e53cc2a666d33c.jpg"),
    Temps("6","https://i.pinimg.com/originals/d1/fe/cb/d1fecbe74fb406e1d4e53cc2a666d33c.jpg"),
    Temps("7","https://i.pinimg.com/originals/d1/fe/cb/d1fecbe74fb406e1d4e53cc2a666d33c.jpg"))




@Preview(showBackground = true)
@Composable
fun CardTempPreview(){

}