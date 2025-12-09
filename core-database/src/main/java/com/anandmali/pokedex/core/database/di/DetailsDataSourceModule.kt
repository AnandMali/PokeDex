package com.anandmali.pokedex.core.database.di

import com.anandmali.pokedex.core.database.pokemonDetails.dataSource.DetailsLocalDataSource
import com.anandmali.pokedex.core.database.pokemonDetails.dataSource.DetailsLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DetailsDataSourceModule {
    @Binds
    @Singleton
    abstract fun bindsDetailsLocalDataSource(
        detailsLocalDataSourceImpl: DetailsLocalDataSourceImpl
    ): DetailsLocalDataSource
}