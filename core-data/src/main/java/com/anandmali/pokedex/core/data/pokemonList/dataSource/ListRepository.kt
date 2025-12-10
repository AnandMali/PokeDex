package com.anandmali.pokedex.core.data.pokemonList.dataSource

import com.anandmali.pokedex.core.common.pokemonList.domain.PokemonDomainData
import com.anandmali.pokedex.core.common.util.DataError
import com.anandmali.pokedex.core.common.util.DataResult

interface ListRepository {
    suspend fun getPokemonList(): DataResult<List<PokemonDomainData>, DataError>
}