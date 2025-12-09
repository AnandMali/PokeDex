package com.anandmali.pokedex.core.database.pokemonDetails.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "pokemon_types",
    foreignKeys = [
        ForeignKey(
            entity = DetailsEntity::class,
            parentColumns = ["id"],
            childColumns = ["pokemonId"],
        )
    ]
)
data class TypesEntity(
    @PrimaryKey val pokemonId: Int,
    val name: String
)
