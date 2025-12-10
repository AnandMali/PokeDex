package com.anandmali.pokedex.core.network.service.pokemonDetails.datasource

import com.anandmali.pokedex.core.model.pokemonDetails.network.PokemonDetailsResponse
import com.anandmali.pokedex.core.model.util.DataError
import com.anandmali.pokedex.core.model.util.DataResult

interface DetailsRemoteDataSource {
    suspend fun getPokemonDetails(
        name: String
    ): DataResult<PokemonDetailsResponse, DataError>
}
