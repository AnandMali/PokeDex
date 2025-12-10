package com.anandmali.pokedex.core.database.pokemonList.mapper

import com.anandmali.pokedex.core.database.pokemonList.model.ListEntity
import com.anandmali.pokedex.core.model.util.DtoMapper
import com.anandmali.pokedex.core.model.pokemonList.domain.PokemonDomainData

object ListDomainMapper : DtoMapper<List<ListEntity>, List<PokemonDomainData>> {
    override fun map(input: List<ListEntity>): List<PokemonDomainData> {
        return input.map {
            PokemonDomainData(
                id = it.id,
                name = it.name,
                url = it.url
            )
        }
    }
}