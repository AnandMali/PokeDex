package com.anandmali.pokedex.core.data.di

import com.anandmali.pokedex.core.data.repository.pokemonDetails.DetailsRepository
import com.anandmali.pokedex.core.data.repository.pokemonDetails.DetailsRepositoryImpl
import com.anandmali.pokedex.core.data.repository.pokemonList.ListRepository
import com.anandmali.pokedex.core.data.repository.pokemonList.ListRepositoryImpl
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