package com.anandmali.pokedex.core.database.list.dataSource

import com.anandmali.pokedex.core.database.list.model.PokemonEntity
import com.anandmali.pokedex.core.model.util.DataError
import com.anandmali.pokedex.core.model.util.DataResult

interface PokemonLocalDataSource {
    suspend fun getPokemonList(): DataResult<List<PokemonEntity>, DataError>

    suspend fun insertPokemonList(pokemonList: List<PokemonEntity>)
}