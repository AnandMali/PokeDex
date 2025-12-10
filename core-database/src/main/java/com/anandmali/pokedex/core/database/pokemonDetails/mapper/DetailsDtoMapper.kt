package com.anandmali.pokedex.core.database.pokemonDetails.mapper

import com.anandmali.pokedex.core.database.pokemonDetails.model.DetailsEntity
import com.anandmali.pokedex.core.common.util.DtoMapper
import com.anandmali.pokedex.core.common.pokemonDetails.network.PokemonDetailsResponse

object DetailsDtoMapper :
    DtoMapper<PokemonDetailsResponse, DetailsEntity> {
    override fun map(input: PokemonDetailsResponse): DetailsEntity {
        return with(input) {
            DetailsEntity(
                id = id,
                height = height,
                name = name,
                order = order,
                weight = weight
            )
        }
    }
}
