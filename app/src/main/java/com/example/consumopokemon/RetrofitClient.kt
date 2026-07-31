package com.example.consumopokemon

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://pokeapi.co/api/v2/"


    // Interceptor que loggea las peticiones en Logcat
    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    // Cliente OkHttp con el interceptor
    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    // La instancia de la API, lista para usar
    val api: PokeAPIService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PokeAPIService::class.java)
}