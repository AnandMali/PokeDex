package com.anandmali.pokedex.core.model.list

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