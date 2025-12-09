package com.anandmali.pokedex.core.database.pokemonDetails.dataSource

import com.anandmali.pokedex.core.model.pokemonDetails.domain.PokemonDetailsDomainData
import com.anandmali.pokedex.core.model.pokemonDetails.network.PokemonDetailsResponse
import com.anandmali.pokedex.core.model.util.DataError
import com.anandmali.pokedex.core.model.util.DataResult

interface DetailsLocalDataSource {
    suspend fun insertPokemonDetails(pokemonDetailsResponse: PokemonDetailsResponse)
    suspend fun getPokemonDetails(id: Int): DataResult<PokemonDetailsDomainData, DataError>
}