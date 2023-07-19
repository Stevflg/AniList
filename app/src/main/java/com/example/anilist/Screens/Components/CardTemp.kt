package com.example.anilist.Screens.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.anilist.R

@Composable
fun CardTemp(){
    Column (modifier = Modifier.size(40.dp)){
        /*AsyncImage(model = "", contentDescription = "Portada", modifier = Modifier.
        clip(RoundedCornerShape(20)))*/
        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "Portada",
        modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "Temp 1",color = MaterialTheme.colors.primary,
        modifier = Modifier.align(Alignment.CenterHorizontally))
    }

}
@Preview(showBackground = true)
@Composable
fun CardTempPreview(){
    CardTemp()
}