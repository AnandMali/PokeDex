package com.anandmali.pokedex.core.network.service.info.datasource

import com.anandmali.pokedex.core.model.info.PokeDetailsResponse
import com.anandmali.pokedex.core.model.util.DataError
import com.anandmali.pokedex.core.model.util.DataResult

interface InfoRemoteDataSource {
    suspend fun getPokemonInfo(
        name: String
    ): DataResult<PokeDetailsResponse, DataError>
}
