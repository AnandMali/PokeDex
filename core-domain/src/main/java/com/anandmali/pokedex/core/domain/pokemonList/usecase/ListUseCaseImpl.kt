package com.anandmali.pokedex.core.domain.pokemonList.usecase

import com.anandmali.pokedex.core.data.pokemonList.dataSource.ListRepository
import com.anandmali.pokedex.core.domain.pokemonList.mapper.ListViewDataMapper
import com.anandmali.pokedex.core.domain.pokemonList.model.ListItemViewData
import com.anandmali.pokedex.core.common.util.DataError
import com.anandmali.pokedex.core.common.util.DataResult
import javax.inject.Inject

class ListUseCaseImpl @Inject constructor(
    private val listRepository: ListRepository
) : ListUseCase {
    override suspend fun getPokemonList(): DataResult<List<ListItemViewData>, DataError> {
        return listRepository.getPokemonList()
            .mapSuccess {
                ListViewDataMapper.map(it)
            }
    }
}