package com.anandmali.pokedex.core.database.pokemonDetails.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.anandmali.pokedex.core.database.pokemonDetails.model.DetailsEntity
import com.anandmali.pokedex.core.database.pokemonDetails.model.StatsEntity
import com.anandmali.pokedex.core.database.pokemonDetails.model.TypesEntity

@Dao
interface DetailsDao {
    @Transaction
    suspend fun insertFullDetails(
        details: DetailsEntity,
        stats: List<StatsEntity>,
        types: List<TypesEntity>
    ) {
        insertDetails(details)
        insertStats(stats)
        insertTypes(types)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetails(details: DetailsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStats(stats: List<StatsEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTypes(types: List<TypesEntity>)

    @Transaction
    @Query("SELECT * FROM pokemon_details WHERE id = :id")
    suspend fun getPokemonDetails(id: Int): DetailsWithRelations?
}