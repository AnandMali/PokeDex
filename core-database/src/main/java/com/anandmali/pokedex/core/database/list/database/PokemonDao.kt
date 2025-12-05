package com.anandmali.pokedex.core.database.list.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.anandmali.pokedex.core.database.list.model.PokemonEntity

@Dao
interface PokemonDao {
    @Query("SELECT * FROM pokemon")
    fun getAll(): List<PokemonEntity>

    @Insert
    fun insertAll(vararg pokemonEntities: List<PokemonEntity>)
}