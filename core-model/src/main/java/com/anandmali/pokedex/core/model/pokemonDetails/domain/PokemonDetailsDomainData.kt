package com.anandmali.pokedex.core.model.pokemonDetails.domain

import com.anandmali.pokedex.core.model.pokemonDetails.network.Stat
import com.anandmali.pokedex.core.model.pokemonDetails.network.Type

data class PokemonDetailsDomainData(
    val id: Int,
    val height: Int,
    val name: String,
    val order: Int,
    val stats: List<StatDomainData>,
    val types: List<TypeDomainData>,
    val weight: Int
)