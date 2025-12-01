package com.anandmali.pokedex.core.data.network.response

data class PokeList(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Pokemon>
)

data class Pokemon(
    val name: String,
    val url: String
)