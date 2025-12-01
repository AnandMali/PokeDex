package com.anandmali.pokedex.core.data.repository

import androidx.paging.PagingData
import com.anandmali.pokedex.core.data.Resource
import com.anandmali.pokedex.core.data.network.response.PokeDetailsResponse
import com.anandmali.pokedex.core.data.network.response.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokeRepository {
     fun getPokeList(): Flow<PagingData<Pokemon>>

    suspend fun getPokemonInfo(pokemonName: String): Resource<PokeDetailsResponse>
}