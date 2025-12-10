package com.anandmali.pokedex.core.data.di

import com.anandmali.pokedex.core.data.pokemonDetails.dataSource.DetailsRepository
import com.anandmali.pokedex.core.data.pokemonDetails.dataSource.DetailsRepositoryImpl
import com.anandmali.pokedex.core.data.pokemonList.dataSource.ListRepository
import com.anandmali.pokedex.core.data.pokemonList.dataSource.ListRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsListRepository(
        listRepositoryImpl: ListRepositoryImpl
    ): ListRepository

    @Binds
    @Singleton
    abstract fun bindsDetailsRepository(
        detailsRepositoryImpl: DetailsRepositoryImpl
    ): DetailsRepository
}