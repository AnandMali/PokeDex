package com.anandmali.pokedex.core.database.pokemonList.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.anandmali.pokedex.core.database.pokemonList.model.ListEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ListDao {
    @Insert
    fun insertAll(pokemonEntities: List<ListEntity>)

    @Query("SELECT * FROM pokemon_list")
    fun getAll(): List<ListEntity>
}