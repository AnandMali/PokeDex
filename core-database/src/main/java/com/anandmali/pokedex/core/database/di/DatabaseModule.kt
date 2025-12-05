package com.anandmali.pokedex.core.database.di

import android.content.Context
import androidx.room.Room
import com.anandmali.pokedex.core.database.PokedexDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): PokedexDatabase {
        return Room.databaseBuilder(
            context = context,
            PokedexDatabase::class.java,
            PokedexDatabase.DATABASE_NAME
        ).build()
    }
}