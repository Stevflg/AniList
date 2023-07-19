package com.example.anilist.Data.dto

import com.example.anilist.Data.Domain.TemporadaItem
import com.google.gson.annotations.SerializedName

data class TemporadaModel(
    @SerializedName("AnimeId") val animeId: String,
    @SerializedName("TemporadaId") val temporadaId: String,
    @SerializedName("NomTemporada") val nomTemporada: String,
    @SerializedName("Portada") val portada: String,
    @SerializedName("Episodios") val episodios: List<EpisodiosModel>
)

fun TemporadaItem.toModel() = TemporadaModel(
    animeId, temporadaId, nomTemporada, portada, episodios)

