package com.anandmali.pokedex.core.data.pokemonDetails.dataSource

import com.anandmali.pokedex.core.common.pokemonDetails.domain.PokemonDetailsDomainData
import com.anandmali.pokedex.core.common.util.DataError
import com.anandmali.pokedex.core.common.util.DataResult

interface DetailsRepository {
    suspend fun getPokemonDetails(
        pokemonId: Int
    ): DataResult<PokemonDetailsDomainData, DataError>

    suspend fun getNameById(
        pokemonId: Int
    ): DataResult<String, DataError>
}