package com.anandmali.pokedex.core.database.di

import com.anandmali.pokedex.core.database.PokedexDatabase
import com.anandmali.pokedex.core.database.pokemonList.database.ListDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ListDaoModule {
    @Provides
    @Singleton
    fun provideListDao(
        appDatabase: PokedexDatabase
    ): ListDao {
        return appDatabase.listDao()
    }
}