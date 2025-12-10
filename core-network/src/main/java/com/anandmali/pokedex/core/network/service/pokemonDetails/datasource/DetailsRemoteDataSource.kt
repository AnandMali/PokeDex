package com.anandmali.pokedex.core.network.service.pokemonDetails.datasource

import com.anandmali.pokedex.core.common.pokemonDetails.network.PokemonDetailsResponse
import com.anandmali.pokedex.core.common.util.DataError
import com.anandmali.pokedex.core.common.util.DataResult

interface DetailsRemoteDataSource {
    suspend fun getPokemonDetails(
        name: String
    ): DataResult<PokemonDetailsResponse, DataError>
}
