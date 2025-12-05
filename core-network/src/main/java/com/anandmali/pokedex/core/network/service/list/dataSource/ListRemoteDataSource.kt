package com.anandmali.pokedex.core.network.service.list.dataSource

import com.anandmali.pokedex.core.model.list.PokeList
import com.anandmali.pokedex.core.model.util.DataError
import com.anandmali.pokedex.core.model.util.DataResult

interface ListRemoteDataSource {
    suspend fun getPokeList(
        limit: Int,
        offset: Int
    ): DataResult<PokeList, DataError>
}