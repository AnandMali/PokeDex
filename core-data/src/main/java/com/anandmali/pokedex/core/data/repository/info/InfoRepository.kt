package com.anandmali.pokedex.core.data.repository.info

import com.anandmali.pokedex.core.data.Resource
import com.anandmali.pokedex.core.network.service.info.model.PokeDetailsResponse

interface InfoRepository {
    suspend fun getPokemonInfo(
        name: String
    ): Resource<PokeDetailsResponse>
}