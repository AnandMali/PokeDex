package com.anandmali.pokedex.core.data.pokemonList.dataSource

import com.anandmali.pokedex.core.data.pokemonList.mapper.ListDomainMapper
import com.anandmali.pokedex.core.database.pokemonList.dataSource.ListLocalDataSource
import com.anandmali.pokedex.core.model.pokemonList.domain.PokemonDomainData
import com.anandmali.pokedex.core.model.util.DataError
import com.anandmali.pokedex.core.model.util.DataResult
import com.anandmali.pokedex.core.network.service.pokemonList.dataSource.ListRemoteDataSource
import javax.inject.Inject

class ListRepositoryImpl @Inject constructor(
    private val listLocalDataSource: ListLocalDataSource,
    private val listRemoteDataSource: ListRemoteDataSource,
) : ListRepository {
    /**
     * Fetch from local source, check if success, else fetch from remote source
     * If remote success, clear local source and insert new data
     * Emit data with success or error
     */
    override suspend fun getPokemonList(): DataResult<List<PokemonDomainData>, DataError> {
        val cachedListResult = listLocalDataSource.getPokemonList()
        cachedListResult.fold(
            onSuccess = {
                return DataResult.Success(it)
            },
            onError = {
                return fetchFromRemote()
            }
        )
    }

    private suspend fun fetchFromRemote(): DataResult<List<PokemonDomainData>, DataError> {
        val remoteList = listRemoteDataSource.getPokemonList(10, 0)
        return remoteList.fold(
            onSuccess = {
                listLocalDataSource.insertPokemonList(it.results)
                val domainList = ListDomainMapper.map(it.results)
                DataResult.Success(domainList)
            },
            onError = {
                DataResult.Error(it)
            }
        )
    }
}