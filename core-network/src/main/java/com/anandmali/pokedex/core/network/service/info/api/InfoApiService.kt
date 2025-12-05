package com.anandmali.pokedex.core.network.service.info.api

import com.anandmali.pokedex.core.model.info.PokeDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface InfoApiService {
    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name: String
    ): PokeDetailsResponse
}