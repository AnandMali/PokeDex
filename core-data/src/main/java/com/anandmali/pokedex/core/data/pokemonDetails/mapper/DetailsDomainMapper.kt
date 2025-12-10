package com.anandmali.pokedex.core.data.pokemonDetails.mapper

import com.anandmali.pokedex.core.model.pokemonDetails.domain.PokemonDetailsDomainData
import com.anandmali.pokedex.core.model.pokemonDetails.domain.StatDomainData
import com.anandmali.pokedex.core.model.pokemonDetails.domain.TypeDomainData
import com.anandmali.pokedex.core.model.pokemonDetails.network.PokemonDetailsResponse
import com.anandmali.pokedex.core.model.util.DtoMapper

object DetailsDomainMapper : DtoMapper<PokemonDetailsResponse, PokemonDetailsDomainData> {
    override fun map(input: PokemonDetailsResponse): PokemonDetailsDomainData {
        return with(input) {
            PokemonDetailsDomainData(
                id = input.id,
                name = input.name,
                height = input.height,
                weight = input.weight,
                order = input.order,
                stats = stats.map {
                    StatDomainData(
                        statName = it.name,
                        baseStat = it.base_stat
                    )
                },
                types = types.map {
                    TypeDomainData(
                        name = it.type.name
                    )
                }
            )
        }
    }
}