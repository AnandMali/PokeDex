package com.anandmali.pokedex.core.data.pokemonList.dataSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.anandmali.pokedex.core.model.pokemonList.network.Pokemon
import com.anandmali.pokedex.core.network.service.pokemonList.dataSource.ListRemoteDataSource
import javax.inject.Inject

const val PAGING_SIZE = 10
private const val PAGE_INDEX = 0

class ListPagingSource @Inject constructor(
    private val listRemoteDataSource: ListRemoteDataSource,
) : PagingSource<Int, Pokemon>() {

    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        //Current paging index position
        val position = params.key ?: PAGE_INDEX

        val pokemonList = getPokemonList(params.loadSize, position)

        //Create next paging index
        val nextKey = if (pokemonList.size < PAGING_SIZE) {
            null
        } else {
            position + (params.loadSize / PAGING_SIZE)
        }

        //Create a paging result for PagingData
        return LoadResult.Page(
            data = pokemonList,
            prevKey = if (position == 1) null else position - 1,
            nextKey = nextKey
        )
    }

    private suspend fun getPokemonList(loadSize: Int, position: Int): List<Pokemon> {
        // TODO, resolve paging issues and fetch from remote
        return emptyList()
    }
}