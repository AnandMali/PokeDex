package com.anandmali.pokedex.core.network.service.pokemonDetails.datasource

import com.anandmali.pokedex.core.model.pokemonDetails.network.PokemonDetailsResponse
import com.anandmali.pokedex.core.model.util.DataError
import com.anandmali.pokedex.core.model.util.DataResult

interface DetailsRemoteDataSource {
    suspend fun getPokemonInfo(
        name: String
    ): DataResult<PokemonDetailsResponse, DataError>
}
