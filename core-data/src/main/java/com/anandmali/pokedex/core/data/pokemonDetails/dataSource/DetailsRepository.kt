package com.anandmali.pokedex.core.data.pokemonDetails.dataSource

import com.anandmali.pokedex.core.model.pokemonDetails.domain.PokemonDetailsDomainData
import com.anandmali.pokedex.core.model.util.DataError
import com.anandmali.pokedex.core.model.util.DataResult

interface DetailsRepository {
    suspend fun getPokemonDetails(
        pokemonId: Int,
        pokemonName: String
    ): DataResult<PokemonDetailsDomainData, DataError>
}