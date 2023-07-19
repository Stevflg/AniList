package com.example.anilist.Data.Domain

import com.example.anilist.Data.dto.TemporadaModel


data class AnimeItem(
    val animeId: String,
    val nombre: String,
    val estreno: String,
    val genero: String,
    val portada: String,
    val temporadas: List<TemporadaModel>

)
