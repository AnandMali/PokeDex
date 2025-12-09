package com.anandmali.pokedex.core.data.di.list

import com.anandmali.pokedex.core.data.repository.pokemonList.ListPagingSource
import com.anandmali.pokedex.core.network.service.pokemonList.dataSource.ListRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PagingSourceModel {
    @Singleton
    @Provides
    fun providePagingSource(
        listRemoteDataSource: ListRemoteDataSource
    ): ListPagingSource {
        return ListPagingSource(listRemoteDataSource)
    }
}