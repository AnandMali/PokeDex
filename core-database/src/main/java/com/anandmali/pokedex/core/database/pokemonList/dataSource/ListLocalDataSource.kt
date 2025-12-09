package com.anandmali.pokedex.core.database.pokemonList.dataSource

import com.anandmali.pokedex.core.model.pokemonList.domain.PokemonDomainData
import com.anandmali.pokedex.core.model.pokemonList.network.Pokemon
import com.anandmali.pokedex.core.model.util.DataError
import com.anandmali.pokedex.core.model.util.DataResult

interface ListLocalDataSource {
    suspend fun insertPokemonList(pokemonList: List<Pokemon>)
    suspend fun getPokemonList(): DataResult<List<PokemonDomainData>, DataError>
}