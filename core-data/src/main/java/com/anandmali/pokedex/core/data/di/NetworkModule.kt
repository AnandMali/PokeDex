package com.anandmali.pokedex.core.data.di

import com.anandmali.pokedex.core.data.network.PokeApi
import com.anandmali.pokedex.core.data.repository.ListPagingSource
import com.anandmali.pokedex.core.data.repository.PokeRepository
import com.anandmali.pokedex.core.data.repository.PokeRepositoryImpl
import com.itkacher.okprofiler.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    private val baseUrl: String = "https://pokeapi.co/api/v2/"

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply { HttpLoggingInterceptor.Level.BODY }

        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    } else {
        OkHttpClient
            .Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun providePokeApiService(retrofit: Retrofit): PokeApi {
        return retrofit.create(PokeApi::class.java)
    }

    @Singleton
    @Provides
    fun providePokeRepository(
        apiService: PokeApi,
        pagingSource: ListPagingSource
    ): PokeRepository {
        return PokeRepositoryImpl(apiService, pagingSource)
    }

    @Singleton
    @Provides
    fun providePagingSource(apiService: PokeApi): ListPagingSource {
        return ListPagingSource(apiService)
    }

}