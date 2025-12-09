package com.anandmali.pokedex.core.data.repository.pokemonDetails

import com.anandmali.pokedex.core.data.Resource
import com.anandmali.pokedex.core.model.pokemonDetails.network.PokemonDetailsResponse

interface DetailsRepository {
    suspend fun getPokemonInfo(
        name: String
    ): Resource<PokemonDetailsResponse>
}