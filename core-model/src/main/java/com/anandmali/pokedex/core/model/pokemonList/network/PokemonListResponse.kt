package com.anandmali.pokedex.core.model.pokemonList.network

data class PokemonListResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Pokemon>
)

data class Pokemon(
    val name: String,
    val url: String
) {
    val id: Int
        get() = url.split("/".toRegex()).dropLast(1).last().toInt()
}