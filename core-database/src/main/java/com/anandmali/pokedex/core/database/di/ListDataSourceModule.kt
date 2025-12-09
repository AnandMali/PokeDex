package com.anandmali.pokedex.core.database.di

import com.anandmali.pokedex.core.database.pokemonList.dataSource.ListLocalDataSource
import com.anandmali.pokedex.core.database.pokemonList.dataSource.ListLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ListDataSourceModule {
    @Binds
    @Singleton
    abstract fun bindsListLocalDataSource(
        listLocalDataSourceImpl: ListLocalDataSourceImpl
    ): ListLocalDataSource
}