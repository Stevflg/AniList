package com.example.anilist.Screens.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.anilist.R

@Composable
fun MainScreen(){
    Column(verticalArrangement = Arrangement.Top) {
        Spacer(modifier = Modifier.size(50.dp))
        Text("Menu", color = MaterialTheme.colors.primary,
            style = TextStyle(fontSize = 40.sp), modifier = Modifier.align(alignment = Alignment.CenterHorizontally )
        )
        Text("Principal", color = MaterialTheme.colors.primary,
            style = TextStyle(fontSize = 40.sp), modifier = Modifier.align(alignment = Alignment.CenterHorizontally )
        )
        Spacer(modifier = Modifier.size(40.dp))

            Image(painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription ="Portada",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(300.dp)
                    .width(200.dp)
                    .clip(RoundedCornerShape(20))
                    .align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(20.dp))
        OutlinedButton(onClick = { /*TODO*/ }, colors = ButtonDefaults.outlinedButtonColors(backgroundColor = MaterialTheme.colors.secondary),
        modifier = Modifier.align(Alignment.CenterHorizontally)
            .clip(RoundedCornerShape(80))) {
            Text("  Abrir  ", color = MaterialTheme.colors.primary)
        }


    }
}
@Preview(showSystemUi = true)
@Composable
fun prev(){
    MainScreen()
}
