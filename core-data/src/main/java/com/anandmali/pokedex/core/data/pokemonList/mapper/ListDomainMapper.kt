package com.anandmali.pokedex.core.data.pokemonList.mapper

import com.anandmali.pokedex.core.common.pokemonList.domain.PokemonDomainData
import com.anandmali.pokedex.core.common.pokemonList.network.Pokemon
import com.anandmali.pokedex.core.common.util.DtoMapper

object ListDomainMapper :
    DtoMapper<List<Pokemon>, List<PokemonDomainData>> {
    override fun map(input: List<Pokemon>): List<PokemonDomainData> {
        return input.map {
            PokemonDomainData(
                id = it.id,
                name = it.name,
                url = it.url
            )
        }
    }
}