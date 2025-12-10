package com.anandmali.pokedex.core.network.service.pokemonList.dataSource

import com.anandmali.pokedex.core.model.pokemonList.network.PokemonListResponse
import com.anandmali.pokedex.core.model.util.DataError
import com.anandmali.pokedex.core.model.util.DataResult

interface ListRemoteDataSource {
    suspend fun getPokemonList(
        limit: Int,
        offset: Int
    ): DataResult<PokemonListResponse, DataError>
}