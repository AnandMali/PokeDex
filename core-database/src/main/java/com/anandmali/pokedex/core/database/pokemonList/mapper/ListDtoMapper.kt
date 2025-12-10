package com.anandmali.pokedex.core.database.pokemonList.mapper

import com.anandmali.pokedex.core.database.pokemonList.model.ListEntity
import com.anandmali.pokedex.core.model.pokemonList.network.Pokemon
import com.anandmali.pokedex.core.model.util.DtoMapper

object ListDtoMapper : DtoMapper<List<Pokemon>, List<ListEntity>> {
    override fun map(input: List<Pokemon>): List<ListEntity> {
        return input.map {
            ListEntity(
                id = it.id,
                name = it.name,
                url = it.url,
            )
        }
    }
}