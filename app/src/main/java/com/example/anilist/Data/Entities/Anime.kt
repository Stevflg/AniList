package com.example.anilist.Data.Entities



import com.google.gson.annotations.SerializedName

data class Anime(
    @SerializedName("id") val Id : String,
    @SerializedName("name") val Nombre: String,
    @SerializedName("premiere") val Estreno: String,
    @SerializedName("genres") val Generos: Array<String>,
    @SerializedName("image_url") val Imagen:String
)