package com.anandmali.pokedex.core.domain.pokemonDetails.usecase

import com.anandmali.pokedex.core.domain.pokemonDetails.model.DetailsViewData
import com.anandmali.pokedex.core.model.util.DataError
import com.anandmali.pokedex.core.model.util.DataResult

interface DetailsUseCase {
    suspend fun getDetails(
        pokemonId: Int,
        pokemonName: String
    ): DataResult<DetailsViewData, DataError>
}