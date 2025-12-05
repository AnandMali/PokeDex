package com.anandmali.pokedex.core.data.repository.info

import com.anandmali.pokedex.core.data.Resource
import com.anandmali.pokedex.core.model.info.PokeDetailsResponse

interface InfoRepository {
    suspend fun getPokemonInfo(
        name: String
    ): Resource<PokeDetailsResponse>
}