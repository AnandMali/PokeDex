package com.anandmali.pokedex.core.network.di.pokemonDetails

import com.anandmali.pokedex.core.network.service.pokemonDetails.api.DetailsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DetailsApiModule {
    @Singleton
    @Provides
    fun provideInfoAPi(
        retrofit: Retrofit
    ): DetailsApiService {
        return retrofit.create(DetailsApiService::class.java)
    }
}