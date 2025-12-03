package com.anandmali.pokedex.core.network.service.info.datasource

import com.anandmali.pokedex.core.network.service.info.model.PokeDetailsResponse
import com.anandmali.pokedex.core.network.util.DataError
import com.anandmali.pokedex.core.network.util.DataResult

interface InfoRemoteDataSource {
    suspend fun getPokemonInfo(
        name: String
    ): DataResult<PokeDetailsResponse, DataError>
}
