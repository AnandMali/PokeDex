package com.anandmali.pokedex.core.network.di.list

import com.anandmali.pokedex.core.network.service.list.dataSource.ListRemoteDataSource
import com.anandmali.pokedex.core.network.service.list.dataSource.ListRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class ListDataSourceModule {
    @Singleton
    @Binds
    abstract fun bindRemoteDataSource(
        listRemoteDataSourceImpl: ListRemoteDataSourceImpl
    ): ListRemoteDataSource
}