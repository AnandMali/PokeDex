package com.anandmali.pokedex.core.database.pokemonDetails.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "pokemon_types",
    indices = [Index(value = ["pokemonId"])],
    foreignKeys = [
        ForeignKey(
            entity = DetailsEntity::class,
            parentColumns = ["id"],
            childColumns = ["pokemonId"],
        )
    ]
)
data class TypesEntity(
    @PrimaryKey(autoGenerate = true)
    val typesId: Int = 0,
    val pokemonId: Int,
    val name: String
)
