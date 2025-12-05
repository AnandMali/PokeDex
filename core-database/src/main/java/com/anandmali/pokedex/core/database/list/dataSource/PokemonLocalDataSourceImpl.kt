package com.anandmali.pokedex.core.database.list.dataSource

import com.anandmali.pokedex.core.database.list.model.PokemonEntity
import com.anandmali.pokedex.core.model.util.DataError
import com.anandmali.pokedex.core.model.util.DataResult

class PokemonLocalDataSourceImpl : PokemonLocalDataSource {
    override suspend fun getPokemonList(): DataResult<List<PokemonEntity>, DataError> {
        return DataResult.Success(emptyList())
    }

    override suspend fun insertPokemonList(pokemonList: List<PokemonEntity>) {
        TODO("Not yet implemented")
    }
}