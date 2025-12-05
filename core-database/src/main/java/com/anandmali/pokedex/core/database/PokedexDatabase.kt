package com.anandmali.pokedex.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.anandmali.pokedex.core.database.info.database.InfoDao
import com.anandmali.pokedex.core.database.info.model.InfoEntity

@Database(entities = [InfoEntity::class], version = 1)
abstract class PokedexDatabase : RoomDatabase() {
    companion object {
        const val DATABASE_NAME = "currency_database"
    }
    abstract fun infoDao(): InfoDao
}