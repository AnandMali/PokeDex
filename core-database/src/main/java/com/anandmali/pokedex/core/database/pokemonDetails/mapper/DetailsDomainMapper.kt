package com.anandmali.pokedex.core.database.pokemonDetails.mapper

import com.anandmali.pokedex.core.database.pokemonDetails.database.DetailsWithRelations
import com.anandmali.pokedex.core.common.util.DtoMapper
import com.anandmali.pokedex.core.common.pokemonDetails.domain.PokemonDetailsDomainData
import com.anandmali.pokedex.core.common.pokemonDetails.domain.StatDomainData
import com.anandmali.pokedex.core.common.pokemonDetails.domain.TypeDomainData

object DetailsDomainMapper :
    DtoMapper<DetailsWithRelations, PokemonDetailsDomainData> {
    override fun map(input: DetailsWithRelations): PokemonDetailsDomainData {
        return with(input) {
            PokemonDetailsDomainData(
                id = details.id,
                name = details.name,
                height = details.height,
                weight = details.weight,
                order = details.order,
                stats = stats.map {
                    StatDomainData(
                        statName = it.statName,
                        baseStat = it.baseStat
                    )
                },
                types = types.map {
                    TypeDomainData(
                        name = it.name
                    )
                }
            )
        }
    }
}