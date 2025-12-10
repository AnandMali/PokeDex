package com.anandmali.pokedex.core.network.service.pokemonList.dataSource

import com.anandmali.pokedex.core.common.pokemonList.network.PokemonListResponse
import com.anandmali.pokedex.core.common.util.DataError
import com.anandmali.pokedex.core.common.util.DataResult

interface ListRemoteDataSource {
    suspend fun getPokemonList(
        limit: Int,
        offset: Int
    ): DataResult<PokemonListResponse, DataError>
}