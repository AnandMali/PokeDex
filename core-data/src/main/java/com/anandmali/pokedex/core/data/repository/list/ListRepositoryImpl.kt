package com.anandmali.pokedex.core.data.repository.list

import com.anandmali.pokedex.core.database.pokemonList.dataSource.ListLocalDataSource
import com.anandmali.pokedex.core.model.pokemonList.network.Pokemon
import com.anandmali.pokedex.core.network.service.list.dataSource.ListRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ListRepositoryImpl @Inject constructor(
    private val listLocalDataSource: ListLocalDataSource,
    private val listRemoteDataSource: ListRemoteDataSource,
) : ListRepository {
    override suspend fun getPokeList(): Flow<List<Pokemon>> = flow {
        // TODO resolve paging source issue
        val response = listRemoteDataSource.getPokeList(10, 0)
        response.mapSuccess { response ->
            listLocalDataSource.insertPokemonList(response.results)
            emit(response.results)
        }
    }
}