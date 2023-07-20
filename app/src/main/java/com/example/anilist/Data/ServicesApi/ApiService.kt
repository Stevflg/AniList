package com.example.anilist.Data.ServicesApi

import com.example.anilist.Data.Entities.Anime
import com.example.anilist.Data.Entities.AnimeDetail
import com.example.anilist.Data.Entities.Temporadas
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("anime")
    suspend fun getAnimes(): List<Anime>

    @GET("")
    suspend fun getDetails(@Query("id") Id:String): Call<AnimeDetail>

    @GET("anime/{idAnim}/")
    suspend fun getTremporadas(@Query("idAnim") IdAnim:String):Call<Temporadas>

    @GET ("anime/{id}/")
    suspend fun getCapitulos(@Query("idAnim") IdAnim:String,
                         @Query("id") IdTemp:String): Call<Anime>
}