package com.anandmali.pokedex.core.domain.pokemonList.usecase

import com.anandmali.pokedex.core.common.util.DataError
import com.anandmali.pokedex.core.common.util.DataResult
import com.anandmali.pokedex.core.domain.pokemonList.model.ListItemViewData

interface ListUseCase {
    suspend fun getPokemonList(): DataResult<List<ListItemViewData>, DataError>
}