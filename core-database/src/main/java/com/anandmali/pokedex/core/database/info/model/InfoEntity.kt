package com.anandmali.pokedex.core.database.info.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.anandmali.pokedex.core.model.info.Stat
import com.anandmali.pokedex.core.model.info.Type

@Entity(tableName = "info")
data class InfoEntity(
    @PrimaryKey(autoGenerate = true)
    val height: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
)