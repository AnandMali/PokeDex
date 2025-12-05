package com.anandmali.pokedex.core.database.info.dataSource

import com.anandmali.pokedex.core.database.info.database.InfoDao
import com.anandmali.pokedex.core.model.info.PokeDetailsResponse
import com.anandmali.pokedex.core.model.util.DataError
import com.anandmali.pokedex.core.model.util.DataResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class InfoLocalDataSourceImpl @Inject constructor(
    private val ioDispatcher: CoroutineDispatcher,
    private val infoDao: InfoDao
) : InfoLocalDataSource {
    override suspend fun getPokemonInfo(name: String): DataResult<PokeDetailsResponse, DataError> {
        return withContext(ioDispatcher) {
            val result = infoDao.getInfo()
            result.let {
                DataResult.Success(it)
            }
        }
    }

    override suspend fun insertPokemonInfo(pokemonInfo: PokeDetailsResponse) {
        withContext(ioDispatcher) {
            infoDao.insertAll(pokemonInfo)
        }
    }
}