package com.example.anilist.Data.Domain

import com.example.anilist.Data.dto.EpisodiosModel

data class TemporadaItem(

    val animeId: String,
    val temporadaId: String,
    val nomTemporada: String,
    val portada: String,
    val episodios: List<EpisodiosModel>
)
