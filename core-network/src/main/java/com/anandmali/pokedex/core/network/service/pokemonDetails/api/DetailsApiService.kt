package com.anandmali.pokedex.core.network.service.pokemonDetails.api

import com.anandmali.pokedex.core.model.pokemonDetails.network.PokemonDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailsApiService {
    @GET("pokemon/{name}")
    suspend fun getPokemonDetails(
        @Path("name") name: String
    ): PokemonDetailsResponse
}