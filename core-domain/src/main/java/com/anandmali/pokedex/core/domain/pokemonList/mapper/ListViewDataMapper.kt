package com.anandmali.pokedex.core.domain.pokemonList.mapper

import com.anandmali.pokedex.core.domain.pokemonList.model.ListItemViewData
import com.anandmali.pokedex.core.common.pokemonList.domain.PokemonDomainData
import com.anandmali.pokedex.core.common.util.DtoMapper
import com.anandmali.pokedex.core.domain.util.createImageUrl

object ListViewDataMapper : DtoMapper<List<PokemonDomainData>, List<ListItemViewData>> {
    override fun map(input: List<PokemonDomainData>): List<ListItemViewData> {
        return input.map {
            ListItemViewData(
                id = it.id,
                name = it.name,
                url = it.url,
                imageUrl = createImageUrl(it.id)
            )
        }
    }
}