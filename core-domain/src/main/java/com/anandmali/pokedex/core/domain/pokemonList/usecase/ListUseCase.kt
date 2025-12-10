package com.anandmali.pokedex.core.domain.pokemonList.usecase

import com.anandmali.pokedex.core.domain.pokemonList.model.ListItemViewData
import com.anandmali.pokedex.core.model.util.DataError
import com.anandmali.pokedex.core.model.util.DataResult

interface ListUseCase {
    suspend fun getPokemonList(): DataResult<List<ListItemViewData>, DataError>
}