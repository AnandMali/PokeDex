package com.anandmali.pokedex.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.anandmali.pokedex.core.database.pokemonDetails.database.DetailsDao
import com.anandmali.pokedex.core.database.pokemonDetails.model.DetailsEntity
import com.anandmali.pokedex.core.database.pokemonDetails.model.StatsEntity
import com.anandmali.pokedex.core.database.pokemonDetails.model.TypesEntity
import com.anandmali.pokedex.core.database.pokemonList.database.ListDao
import com.anandmali.pokedex.core.database.pokemonList.model.ListEntity

@Database(
    entities =
        [
            ListEntity::class,
            DetailsEntity::class,
            StatsEntity::class,
            TypesEntity::class
        ],
    version = 1
)
abstract class PokedexDatabase : RoomDatabase() {
    companion object {
        const val DATABASE_NAME = "currency_database"
    }

    abstract fun listDao(): ListDao

    abstract fun detailsDao(): DetailsDao
}