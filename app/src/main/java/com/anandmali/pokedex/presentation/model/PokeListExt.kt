package com.anandmali.pokedex.presentation.model

data class PokemonViewDTO(
    val id: Int,
    val name: String,
    val url: String,
    val imageUrl: String
)

fun createImageUrl(index: Int): String {
    return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$index.png"
}

private fun createId(url: String): Int {
    return url.split("/".toRegex()).dropLast(1).last().toInt()
}