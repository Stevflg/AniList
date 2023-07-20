package com.example.anilist.Screens.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import coil.compose.AsyncImage
import com.example.anilist.Screens.Screen.AnimeDetail

@Composable
fun Prev(){
var show by remember { mutableStateOf(true) }
    if (show){
       show=Dialogo(onDismiss = show)
    }

}
@Composable
fun Dialogo(
    onDismiss: Boolean
): Boolean{
    var value by remember {mutableStateOf(onDismiss)}
    Dialog(onDismissRequest = { value != onDismiss}) {
        Box(modifier = Modifier
            .padding(16.dp)
            .width(300.dp)
            .height(250.dp)
            .clip(RoundedCornerShape(10))
        ){
            AsyncImage(model = "https://i.pinimg.com/originals/d1/fe/cb/d1fecbe74fb406e1d4e53cc2a666d33c.jpg",
                contentDescription = "Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(300.dp)
                    .height(250.dp)
                    .graphicsLayer { alpha = 0.5f }
                    .clip(RoundedCornerShape(10))
            )

            Column(modifier = Modifier
                .width(280.dp)
                .padding(start = 20.dp, end = 20.dp)) {
                Text("Numero de temporada", textDecoration = TextDecoration.Underline ,style = TextStyle(fontSize = 17.sp),
                    textAlign = TextAlign.Center,fontWeight = FontWeight.Bold, color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.size(8.dp))
                Text("Contenido de la previsualizacion" ,style = TextStyle(fontSize = 15.sp),
                    textAlign = TextAlign.Justify, color = MaterialTheme.colors.primary)
            }

            OutlinedButton(onClick = { value = false }, colors = ButtonDefaults.outlinedButtonColors(backgroundColor = MaterialTheme.colors.secondary),
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 20.dp, bottom = 10.dp)) {
                Text("Cancelar", color = MaterialTheme.colors.primary)
            }

            OutlinedButton(onClick = { value = false }, colors = ButtonDefaults.outlinedButtonColors(backgroundColor = MaterialTheme.colors.secondary),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 20.dp, bottom = 10.dp)) {
            Text("Ver Ahora", color = MaterialTheme.colors.primary)
        }
            }
        }
    return value
}
