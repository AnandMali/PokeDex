package com.anandmali.pokedex.core.data.pokemonList.dataSource

import com.anandmali.pokedex.core.model.pokemonList.domain.PokemonDomainData
import com.anandmali.pokedex.core.model.util.DataError
import com.anandmali.pokedex.core.model.util.DataResult

interface ListRepository {
    suspend fun getPokemonList(): DataResult<List<PokemonDomainData>, DataError>
}