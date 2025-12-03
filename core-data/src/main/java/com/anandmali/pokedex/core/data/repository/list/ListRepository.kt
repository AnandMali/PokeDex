package com.anandmali.pokedex.core.data.repository.list

import androidx.paging.PagingData
import com.anandmali.pokedex.core.data.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface ListRepository {
    fun getPokeList(): Flow<PagingData<Pokemon>>
}