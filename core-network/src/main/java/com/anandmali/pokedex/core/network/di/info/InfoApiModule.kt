package com.anandmali.pokedex.core.network.di.info

import com.anandmali.pokedex.core.network.service.info.api.InfoApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InfoApiModule {
    @Singleton
    @Provides
    fun provideInfoAPi(
        retrofit: Retrofit
    ): InfoApiService {
        return retrofit.create(InfoApiService::class.java)
    }
}