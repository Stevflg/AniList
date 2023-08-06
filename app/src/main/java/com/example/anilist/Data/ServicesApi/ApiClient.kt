package com.example.anilist.Data.ServicesApi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {
    private const val BASE_URL = "https://anilist-1-t3664645.deta.app/"

    val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    val apiService: ApiService by lazy { retrofit.create(ApiService::class.java)}
}