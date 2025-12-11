package com.anandmali.pokedex.core.common.pokemonDetails.domain


data class StatDomainData(
    val statName: String,
    val baseStat: Int,
) {
    val name: String
        get() = when (statName) {
            "hp" -> "HP"
            "attack" -> "ATTACK"
            "defense" -> "DEFENCE"
            "special-attack" -> "SPECIAL ATTACK"
            "special-defense" -> "SPECIAL DEFENSE"
            "speed" -> "SPEED"
            else -> statName
        }
}