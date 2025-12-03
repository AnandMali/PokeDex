package com.anandmali.pokedex.core.network.di.info

import com.anandmali.pokedex.core.network.service.info.datasource.InfoRemoteDataSource
import com.anandmali.pokedex.core.network.service.info.datasource.InfoRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class InfoDataSourceModule {
    @Singleton
    @Binds
    abstract fun bindRemoteDataSource(
        infoRemoteDataSourceImpl: InfoRemoteDataSourceImpl
    ): InfoRemoteDataSource
}