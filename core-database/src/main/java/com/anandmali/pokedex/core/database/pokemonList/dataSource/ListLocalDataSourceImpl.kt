package com.anandmali.pokedex.core.database.pokemonList.dataSource

import com.anandmali.pokedex.core.database.pokemonList.database.ListDao
import com.anandmali.pokedex.core.database.pokemonList.mapper.ListDomainMapper
import com.anandmali.pokedex.core.database.pokemonList.mapper.ListDtoMapper
import com.anandmali.pokedex.core.common.pokemonList.domain.PokemonDomainData
import com.anandmali.pokedex.core.common.pokemonList.network.Pokemon
import com.anandmali.pokedex.core.common.util.DataError
import com.anandmali.pokedex.core.common.util.DataResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ListLocalDataSourceImpl @Inject constructor(
    private val ioDispatcher: CoroutineDispatcher,
    private val listDao: ListDao
) : ListLocalDataSource {
    override suspend fun insertPokemonList(pokemonList: List<Pokemon>) {
        withContext(ioDispatcher) {
            val listEntity = ListDtoMapper.map(pokemonList)
            listDao.insertAll(listEntity)
        }
    }

    override suspend fun getPokemonList(): DataResult<List<PokemonDomainData>, DataError> {
        return withContext(ioDispatcher) {
            val entityList = listDao.getAll()
            val domainList = ListDomainMapper.map(entityList)
            if (domainList.isNotEmpty()) {
                DataResult.Success(domainList)
            } else {
                DataResult.Error(DataError.NoData)
            }
        }
    }

    override suspend fun getPokemonNameById(pokemonId: Int): String {
        return withContext(ioDispatcher) {
            listDao.getPokemonNameById(pokemonId)
        }
    }
}