package com.anandmali.pokedex.nav

sealed class Screen(val route: String) {
    data object PokemonList : Screen("pokemon_list")
    data object PokemonDetails : Screen("pokemon_details/{pokemonId}") {
        fun createRoute(pokemonId: Int) = "pokemon_details/$pokemonId"
    }
}
