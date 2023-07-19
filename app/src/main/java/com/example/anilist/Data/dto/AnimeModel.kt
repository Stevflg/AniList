package com.example.anilist.Data.dto

import com.example.anilist.Data.Domain.AnimeItem
import com.google.gson.annotations.SerializedName

data class AnimeModel(
    @SerializedName ("AnimeId") val animeId: String,
    @SerializedName ("Nombre") val nombre: String,
    @SerializedName ("Estreno") val estreno: String,
    @SerializedName ("Genero") val genero: String,
    @SerializedName ("Portada") val portada: String,
    @SerializedName ("temporadas") val temporadas: List<TemporadaModel>
)
fun AnimeItem.toModel() = AnimeModel(
    animeId, nombre, estreno, genero, portada, temporadas
)

