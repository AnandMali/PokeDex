package com.anandmali.pokedex.core.data.repository.info

import com.anandmali.pokedex.core.data.Resource
import com.anandmali.pokedex.core.model.pokemonDetails.network.PokemonDetailsResponse

interface InfoRepository {
    suspend fun getPokemonInfo(
        name: String
    ): Resource<PokemonDetailsResponse>
}