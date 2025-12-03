package com.anandmali.pokedex.core.data.repository.list

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.anandmali.pokedex.core.data.model.Pokemon
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ListRepositoryImpl @Inject constructor(
    private val pagingSource: ListPagingSource
) : ListRepository {
    override fun getPokeList(): Flow<PagingData<Pokemon>> {
        return Pager(
            config = PagingConfig(pageSize = PAGING_SIZE, enablePlaceholders = false),
            pagingSourceFactory = { pagingSource }
        ).flow
    }
}