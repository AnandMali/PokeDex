package com.anandmali.pokedex.core.database.pokemonDetails.mapper

import com.anandmali.pokedex.core.database.pokemonDetails.model.DetailsEntity
import com.anandmali.pokedex.core.database.util.DtoMapper
import com.anandmali.pokedex.core.model.pokemonDetails.network.PokemonDetailsResponse

object DetailsDtoMapper : DtoMapper<PokemonDetailsResponse, DetailsEntity> {
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
