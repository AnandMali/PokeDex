package com.anandmali.pokedex.core.network.di.list

import com.anandmali.pokedex.core.network.service.list.api.ListApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ListApiModule {
    @Singleton
    @Provides
    fun provideListAPi(
        retrofit: Retrofit
    ): ListApiService {
        return retrofit.create(ListApiService::class.java)
    }
}
