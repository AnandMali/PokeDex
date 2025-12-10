package com.anandmali.pokedex.core.network.service.pokemonList.api

import com.anandmali.pokedex.core.model.pokemonList.network.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ListApiService {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonListResponse
}