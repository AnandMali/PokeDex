package com.anandmali.pokedex.core.database.pokemonDetails.dataSource

import com.anandmali.pokedex.core.common.pokemonDetails.domain.PokemonDetailsDomainData
import com.anandmali.pokedex.core.common.pokemonDetails.network.PokemonDetailsResponse
import com.anandmali.pokedex.core.common.util.DataError
import com.anandmali.pokedex.core.common.util.DataResult

interface DetailsLocalDataSource {
    suspend fun insertPokemonDetails(pokemonDetailsResponse: PokemonDetailsResponse)
    suspend fun getPokemonDetails(id: Int): DataResult<PokemonDetailsDomainData, DataError>
}