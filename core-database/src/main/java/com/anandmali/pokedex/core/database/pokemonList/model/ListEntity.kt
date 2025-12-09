package com.anandmali.pokedex.core.database.pokemonList.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon_list")
data class ListEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val url: String
)
