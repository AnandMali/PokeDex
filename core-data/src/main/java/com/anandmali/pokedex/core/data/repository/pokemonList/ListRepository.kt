package com.anandmali.pokedex.core.data.repository.pokemonList

import com.anandmali.pokedex.core.model.pokemonList.network.Pokemon
import kotlinx.coroutines.flow.Flow

interface ListRepository {
    suspend fun getPokeList(): Flow<List<Pokemon>>
}