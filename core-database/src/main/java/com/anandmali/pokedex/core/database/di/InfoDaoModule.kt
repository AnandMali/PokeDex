package com.anandmali.pokedex.core.database.di

import com.anandmali.pokedex.core.database.PokedexDatabase
import com.anandmali.pokedex.core.database.info.database.InfoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InfoDaoModule {
    @Provides
    @Singleton
    fun provideInfoDao(
        appDatabase: PokedexDatabase
    ): InfoDao {
        return appDatabase.infoDao()
    }
}