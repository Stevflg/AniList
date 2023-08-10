package com.example.anilist.Data.ServicesApi

import com.example.anilist.Data.Entities.Anime
import com.example.anilist.Data.Entities.AnimeDetail
import com.example.anilist.Data.Entities.Temporadas
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {
    @GET("anime/")
    suspend fun getAnimes(): List<Anime>

    @GET
    suspend fun getDetails(@Url Id:String): List<AnimeDetail>

    @GET()
    suspend fun getTemporadas(@Url anime_id:String):List<Temporadas>

    @GET
    suspend fun getCapitulos(@Url IdAnim_Temp:String): List<Anime>
}