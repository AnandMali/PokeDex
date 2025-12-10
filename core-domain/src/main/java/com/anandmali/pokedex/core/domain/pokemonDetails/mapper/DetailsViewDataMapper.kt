package com.anandmali.pokedex.core.domain.pokemonDetails.mapper

import com.anandmali.pokedex.core.domain.pokemonDetails.model.DetailsViewData
import com.anandmali.pokedex.core.domain.util.createImageUrl
import com.anandmali.pokedex.core.common.pokemonDetails.domain.PokemonDetailsDomainData
import com.anandmali.pokedex.core.common.util.DtoMapper

object DetailsViewDataMapper : DtoMapper<PokemonDetailsDomainData, DetailsViewData> {
    override fun map(input: PokemonDetailsDomainData): DetailsViewData {
        return with(input) {
            DetailsViewData(
                id = id,
                height = height,
                weight = weight,
                name = name,
                order = order,
                stats = stats,
                types = types,
                imageUrl = createImageUrl(id)
            )
        }
    }
}