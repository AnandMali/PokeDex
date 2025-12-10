package com.anandmali.pokedex.core.domain.pokemonDetails.model

import com.anandmali.pokedex.core.model.pokemonDetails.domain.StatDomainData
import com.anandmali.pokedex.core.model.pokemonDetails.domain.TypeDomainData

data class DetailsViewData(
    val id: Int,
    val height: Int,
    val name: String,
    val order: Int,
    val stats: List<StatDomainData>,
    val types: List<TypeDomainData>,
    val weight: Int,
    val imageUrl: String
)
