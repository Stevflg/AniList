package com.example.anilist.Data.Entities

import com.google.gson.annotations.SerializedName

data class Temporadas(
    @SerializedName("id") val Id : String,
    @SerializedName("seasons") val Temporadas: List<Temps>,
    @SerializedName("anime_id") val IdAnime:String,
    @SerializedName("anime_name") val NombreAnime: String
)
data class Temps(
    @SerializedName("number") val Numero : String,
    @SerializedName("image_url") val Imagen: String

    )