package com.anandmali.pokedex.core.database.pokemonDetails.database

import androidx.room.Embedded
import androidx.room.Relation
import com.anandmali.pokedex.core.database.pokemonDetails.model.DetailsEntity
import com.anandmali.pokedex.core.database.pokemonDetails.model.StatsEntity
import com.anandmali.pokedex.core.database.pokemonDetails.model.TypesEntity

data class DetailsWithRelations(
    @Embedded val details: DetailsEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "pokemonId"
    )
    val stats: List<StatsEntity>,

    @Relation(
        parentColumn = "id",
        entityColumn = "pokemonId"
    )
    val types: List<TypesEntity>
)