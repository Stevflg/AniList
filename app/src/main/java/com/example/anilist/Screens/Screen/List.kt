package com.example.anilist.Screens.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import com.example.anilist.Data.Entities.Anime
import com.example.anilist.Data.MyViewModel
import com.example.anilist.Screens.Components.CardAnime
import com.example.anilist.Screens.Components.list

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
        val viewModel:MyViewModel = MyViewModel()
        val listAnime=viewModel.itemLiveData
        LaunchedEffect(true){
            viewModel.fetchAnimes()
        }
        Content(listanimes = listAnime.value!!)
    }
}
@Composable
fun Content(listanimes: List<Anime>){
    LazyColumn{
        items(listanimes?: emptyList()){ lista ->
        CardAnime(lista)
        }
    }
}

/*private fun getRetrofit(): Retrofit{
    return Retrofit.Builder()
        .baseUrl("anilist-1-t3664645.deta.app/")
        .addConverterFactory(
            GsonConverterFactory.create())
        .build()
}
private fun anime_list__(Anime_list: MutableList<Anime>) {
     try{
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(ApiService::class.java).getAnimes("anime/")
            val animes = call.body()

            withContext(Dispatchers.Main){
                //Log.e("call",call.toString())
                if(call.isSuccessful){
                    val list = listOf<Anime>(animes!!)
                    Anime_list.clear()
                    Anime_list.addAll(list)
                }
            }
        }
        }catch (e:Exception){
        } }
*/