//package com.anandmali.pokedex.core.data.repository
//
//import androidx.paging.PagingData
//import com.anandmali.pokedex.core.data.Resource
//import com.anandmali.pokedex.core.network.service.info.model.PokeDetailsResponse
//import com.anandmali.pokedex.core.data.remote.response.Pokemon
//import kotlinx.coroutines.flow.Flow
//
//interface InfoRepository {
//     fun getPokeList(): Flow<PagingData<Pokemon>>
//
//    suspend fun getPokemonInfo(pokemonName: String): Resource<PokeDetailsResponse>
//}