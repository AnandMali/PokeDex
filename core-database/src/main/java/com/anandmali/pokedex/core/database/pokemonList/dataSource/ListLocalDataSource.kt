package com.anandmali.pokedex.core.database.pokemonList.dataSource

import com.anandmali.pokedex.core.common.pokemonList.domain.PokemonDomainData
import com.anandmali.pokedex.core.common.pokemonList.network.Pokemon
import com.anandmali.pokedex.core.common.util.DataError
import com.anandmali.pokedex.core.common.util.DataResult

interface ListLocalDataSource {
    suspend fun insertPokemonList(pokemonList: List<Pokemon>)
    suspend fun getPokemonList(): DataResult<List<PokemonDomainData>, DataError>
    suspend fun getPokemonNameById(pokemonId: Int): DataResult<String, DataError>
}