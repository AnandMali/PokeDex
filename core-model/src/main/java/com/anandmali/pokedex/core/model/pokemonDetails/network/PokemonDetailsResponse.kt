package com.anandmali.pokedex.core.model.pokemonDetails.network

data class PokemonDetailsResponse(
    val id: Int,
    val height: Int,
    val name: String,
    val order: Int,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
)