package com.anandmali.pokedex.core.database.pokemonDetails.mapper

import com.anandmali.pokedex.core.database.pokemonDetails.model.StatsEntity
import com.anandmali.pokedex.core.common.pokemonDetails.network.Stat
import com.anandmali.pokedex.core.common.util.DtoMapper

class StatsDtoMapper(private val primaryId: Int) :
    DtoMapper<Stat, StatsEntity> {
    override fun map(input: Stat): StatsEntity {
        return with(input) {
            StatsEntity(
                pokemonId = primaryId,
                statName = name,
                baseStat = base_stat
            )
        }
    }
}