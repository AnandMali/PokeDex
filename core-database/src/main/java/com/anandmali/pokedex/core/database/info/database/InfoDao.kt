package com.anandmali.pokedex.core.database.info.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.anandmali.pokedex.core.database.info.model.InfoEntity
import com.anandmali.pokedex.core.model.info.PokeDetailsResponse

@Dao
interface InfoDao {

    @Query("SELECT * FROM info")
    fun getInfo(): PokeDetailsResponse

    @Insert
    fun insertAll(vararg infoEntity: InfoEntity)
}