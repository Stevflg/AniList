package com.example.anilist.Screens.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.anilist.Screens.Components.CardAnime
import com.example.anilist.Screens.Components.Dialogo

@Composable
fun MainScreen(){
    var show by remember { mutableStateOf(false) }
    Column(verticalArrangement = Arrangement.Top) {
        Spacer(modifier = Modifier.size(50.dp))
        Text("Menu", color = MaterialTheme.colors.primary,
            style = TextStyle(fontSize = 30.sp), modifier = Modifier.align(alignment = Alignment.CenterHorizontally )
        )
        Text("Principal", color = MaterialTheme.colors.primary,
            style = TextStyle(fontSize = 30.sp), modifier = Modifier.align(alignment = Alignment.CenterHorizontally )
        )
        Spacer(modifier = Modifier.size(10.dp))
        Box(modifier = Modifier
            .width(200.dp)
            .height(290.dp)
            .align(Alignment.CenterHorizontally))
        {
            AsyncImage(model = "https://pm1.narvii.com/6571/5109c140269cef1eddf6301575dfe133fe1d2d51_hq.jpg",
                contentScale = ContentScale.Crop,
                contentDescription = "Portada",
                modifier = Modifier
                    .clip(RoundedCornerShape(10))
                    .width(200.dp)
                    .height(270.dp)
                    .align(Alignment.Center))
        }
        Spacer(modifier = Modifier.size(20.dp))
        Button(onClick = { show = true
                         }, colors = ButtonDefaults.outlinedButtonColors(backgroundColor = MaterialTheme.colors.secondary),
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .clip(RoundedCornerShape(80))) {
            Text("  Abrir  ", color = MaterialTheme.colors.primary)
        }
        if (show){
            List()
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun prev(){
    MainScreen()
}
