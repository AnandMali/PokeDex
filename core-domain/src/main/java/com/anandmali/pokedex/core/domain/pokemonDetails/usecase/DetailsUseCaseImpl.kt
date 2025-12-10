package com.anandmali.pokedex.core.domain.pokemonDetails.usecase

import com.anandmali.pokedex.core.data.pokemonDetails.dataSource.DetailsRepository
import com.anandmali.pokedex.core.domain.pokemonDetails.mapper.DetailsViewDataMapper
import com.anandmali.pokedex.core.domain.pokemonDetails.model.DetailsViewData
import com.anandmali.pokedex.core.common.util.DataError
import com.anandmali.pokedex.core.common.util.DataResult
import javax.inject.Inject

class DetailsUseCaseImpl @Inject constructor(
    private val detailsRepository: DetailsRepository
) : DetailsUseCase {
    override suspend fun getDetails(
        pokemonId: Int,
        pokemonName: String
    ): DataResult<DetailsViewData, DataError> {
        return detailsRepository.getPokemonDetails(
            pokemonId,
            pokemonName
        ).mapSuccess {
            DetailsViewDataMapper.map(it)
        }
    }
}