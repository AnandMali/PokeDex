package com.anandmali.pokedex.core.common.pokemonDetails.network

data class Stat(
    val base_stat: Int,
    val effort: Int,
    val stat: StatX
) {
    val name: String
        get() = when (stat.name) {
            "hp" -> "HP"
            "attack" -> "ATTACK"
            "defense" -> "DEFENCE"
            "special-attack" -> "SPECIAL ATTACK"
            "special-defense" -> "SPECIAL DEFENSE"
            "speed" -> "SPEED"
            else -> stat.name
        }
}