package com.anandmali.pokedex.core.network.service.list.api

import com.anandmali.pokedex.core.model.list.PokeList
import retrofit2.http.GET
import retrofit2.http.Query

interface ListApiService {
    @GET("pokemon")
    suspend fun getPokeList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokeList
}