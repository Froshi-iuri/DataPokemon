package com.example.consumopokemon

import android.R

data class DataPokemon(
    val name: String,
    val url: String
)

data class Results(
    val results: List <DataPokemon>
)