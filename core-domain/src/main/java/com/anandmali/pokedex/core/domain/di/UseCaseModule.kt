package com.anandmali.pokedex.core.domain.di

import com.anandmali.pokedex.core.domain.pokemonDetails.usecase.DetailsUseCase
import com.anandmali.pokedex.core.domain.pokemonDetails.usecase.DetailsUseCaseImpl
import com.anandmali.pokedex.core.domain.pokemonList.usecase.ListUseCase
import com.anandmali.pokedex.core.domain.pokemonList.usecase.ListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {
    @Binds
    @Singleton
    abstract fun bindsListUseCase(
        listUseCase: ListUseCaseImpl
    ): ListUseCase

    @Binds
    @Singleton
    abstract fun bindDetailsUseCase(
        detailsUseCase: DetailsUseCaseImpl
    ): DetailsUseCase
}