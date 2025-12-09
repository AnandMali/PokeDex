package com.anandmali.pokedex.core.network.di.pokemonDetails

import com.anandmali.pokedex.core.network.service.pokemonDetails.datasource.DetailsRemoteDataSource
import com.anandmali.pokedex.core.network.service.pokemonDetails.datasource.DetailsRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DetailsDataSourceModule {
    @Singleton
    @Binds
    abstract fun bindRemoteDataSource(
        detailsRemoteDataSourceImpl: DetailsRemoteDataSourceImpl
    ): DetailsRemoteDataSource
}