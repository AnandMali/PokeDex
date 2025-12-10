package com.anandmali.pokedex.core.database.pokemonDetails.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "pokemon_stats",
    indices = [Index(value = ["pokemonId"])],
    foreignKeys = [
        ForeignKey(
            entity = DetailsEntity::class,
            parentColumns = ["id"],
            childColumns = ["pokemonId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class StatsEntity(
    @PrimaryKey(autoGenerate = true)
    val statId: Int = 0,
    val pokemonId: Int,
    val statName: String,
    val baseStat: Int,
)
