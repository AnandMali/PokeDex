package com.anandmali.pokedex.core.database.info.dataSource

import com.anandmali.pokedex.core.model.info.PokeDetailsResponse
import com.anandmali.pokedex.core.model.util.DataError
import com.anandmali.pokedex.core.model.util.DataResult

interface InfoLocalDataSource {
    suspend fun getPokemonInfo(name: String): DataResult<PokeDetailsResponse, DataError>

    suspend fun insertPokemonInfo(pokemonInfo: PokeDetailsResponse)

}