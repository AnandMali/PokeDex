package com.anandmali.pokedex.core.domain.util

fun createImageUrl(index: Int): String {
    return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$index.png"
}