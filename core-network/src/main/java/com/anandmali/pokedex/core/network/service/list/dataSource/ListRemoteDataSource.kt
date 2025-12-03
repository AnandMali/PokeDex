package com.anandmali.pokedex.core.network.service.list.dataSource

import com.anandmali.pokedex.core.network.service.list.model.PokeList
import com.anandmali.pokedex.core.network.util.DataError
import com.anandmali.pokedex.core.network.util.DataResult

interface ListRemoteDataSource {
    suspend fun getPokeList(
        limit: Int,
        offset: Int
    ): DataResult<PokeList, DataError>
}