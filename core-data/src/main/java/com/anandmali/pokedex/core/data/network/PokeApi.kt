package com.anandmali.pokedex.core.data.network

import com.anandmali.pokedex.core.data.network.response.PokeDetailsResponse
import com.anandmali.pokedex.core.data.network.response.PokeList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {

    @GET("pokemon")
    suspend fun getPokeList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<PokeList>

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name: String
    ): PokeDetailsResponse

}