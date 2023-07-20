package com.example.anilist.Data.Entities

import com.google.gson.annotations.SerializedName

data class AnimeDetail(
    @SerializedName ("id") val Id : String,
    @SerializedName("name") val Nombre: String,
    @SerializedName("premiere") val Estreno: String,
    @SerializedName("genres") val Generos: Array<String>,
    @SerializedName("description") val Descripcion:String,
    @SerializedName("anime_id") val IdAnime:String,
    @SerializedName("season_number") val Temporadas:String
)
