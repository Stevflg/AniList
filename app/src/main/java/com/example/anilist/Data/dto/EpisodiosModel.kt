package com.example.anilist.Data.dto

import com.example.anilist.Data.Domain.EpisodiosItem
import com.google.gson.annotations.SerializedName

data class EpisodiosModel(
    @SerializedName("EpisodioId") val episodioId: String,
    @SerializedName("NomEpisodio") val nomEpisodio: String,
    @SerializedName("VideoUrl") val videoUrl: String,
    @SerializedName("AnimeId") val animeId: String,
    @SerializedName("TemporadaId") val temporadaId: String
)

fun EpisodiosItem.toModel() = EpisodiosModel(
    episodioId, nomEpisodio, videoUrl, animeId, temporadaId
)