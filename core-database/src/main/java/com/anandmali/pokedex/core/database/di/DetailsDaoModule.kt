package com.anandmali.pokedex.core.database.di

import com.anandmali.pokedex.core.database.PokedexDatabase
import com.anandmali.pokedex.core.database.pokemonDetails.database.DetailsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DetailsDaoModule {
    @Provides
    @Singleton
    fun provideDetailsDao(
        appDatabase: PokedexDatabase
    ): DetailsDao {
        return appDatabase.detailsDao()
    }
}