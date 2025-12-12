package com.anandmali.pokedex.core.domain.pokemonDetails.usecase

import com.anandmali.pokedex.core.domain.pokemonDetails.model.DetailsViewData
import com.anandmali.pokedex.core.common.util.DataError
import com.anandmali.pokedex.core.common.util.DataResult

interface DetailsUseCase {
    suspend fun getDetails(
        pokemonId: Int
    ): DataResult<DetailsViewData, DataError>

    suspend fun getNameById(
        pokemonId: Int
    ): DataResult<String, DataError>
}