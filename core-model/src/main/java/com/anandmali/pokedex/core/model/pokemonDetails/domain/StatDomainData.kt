package com.anandmali.pokedex.core.model.pokemonDetails.domain


data class StatDomainData(
    val statName: String,
    val baseStat: Int,
) {

    val maxValue: Int
        get() = when (name) {
            "hp" -> maxHp
            "attack" -> maxAttack
            "defense" -> maxDefense
            "special-attack" -> maxSpAttack
            "special-defense" -> maxSpDefense
            "speed" -> maxSpeed
            else -> baseStat
        }

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

    companion object {
        const val maxHp = 100
        const val maxAttack = 100
        const val maxDefense = 100
        const val maxSpAttack = 100
        const val maxSpDefense = 100
        const val maxSpeed = 100
    }
}