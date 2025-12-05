package com.anandmali.pokedex.core.data.repository.list

import androidx.paging.PagingSource
import com.anandmali.pokedex.core.database.list.dataSource.PokemonLocalDataSource
import com.anandmali.pokedex.core.database.list.mapper.asEntity
import com.anandmali.pokedex.core.model.list.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ListRepositoryImpl @Inject constructor(
    private val pagingSource: ListPagingSource,
    private val pokemonLocalDataSource: PokemonLocalDataSource
) : ListRepository {
    override suspend fun getPokeList(): Flow<List<Pokemon>> = flow {

        val response = pagingSource.load(
            PagingSource.LoadParams.Refresh(
                key = null,
                loadSize = PAGING_SIZE,
                placeholdersEnabled = false
            )
        )

        val pokemons = (response as? PagingSource.LoadResult.Page)?.data ?: emptyList()
        val pokemonEntity = pokemons.asEntity()
        pokemonLocalDataSource.insertPokemonList(pokemonEntity)
        emit(pokemons)
    }
}