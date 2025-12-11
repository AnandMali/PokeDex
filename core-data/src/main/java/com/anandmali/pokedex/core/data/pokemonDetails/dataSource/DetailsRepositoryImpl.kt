package com.anandmali.pokedex.core.data.pokemonDetails.dataSource

import com.anandmali.pokedex.core.data.pokemonDetails.mapper.DetailsDomainMapper
import com.anandmali.pokedex.core.database.pokemonDetails.dataSource.DetailsLocalDataSource
import com.anandmali.pokedex.core.common.pokemonDetails.domain.PokemonDetailsDomainData
import com.anandmali.pokedex.core.common.util.DataError
import com.anandmali.pokedex.core.common.util.DataResult
import com.anandmali.pokedex.core.database.pokemonList.dataSource.ListLocalDataSource
import com.anandmali.pokedex.core.network.service.pokemonDetails.datasource.DetailsRemoteDataSource
import javax.inject.Inject

class DetailsRepositoryImpl @Inject constructor(
    private val detailsRemoteDataSource: DetailsRemoteDataSource,
    private val detailsLocalDataSource: DetailsLocalDataSource,
    private val listLocalDataSource: ListLocalDataSource
) : DetailsRepository {

    /**
     * Fetch from local source, check if success, else fetch from remote source
     * For remote API fetch pokemon name from local for given id
     * If remote success, clear local source and insert new data
     * Emit data with success or error
     */
    override suspend fun getPokemonDetails(
        pokemonId: Int
    ): DataResult<PokemonDetailsDomainData, DataError> {
        val cachedPokemonDetails = detailsLocalDataSource.getPokemonDetails(pokemonId)
        cachedPokemonDetails.fold(
            onSuccess = {
                return DataResult.Success(it)
            },
            onError = {
                val pokemonName = fetchPokemonName(pokemonId)
                return fetchFromRemote(pokemonName)
            }
        )
    }

    private suspend fun fetchFromRemote(pokemonName: String): DataResult<PokemonDetailsDomainData, DataError> {
        return detailsRemoteDataSource
            .getPokemonDetails(pokemonName)
            .mapSuccess {
                detailsLocalDataSource.insertPokemonDetails(it)
                val domainData = DetailsDomainMapper.map(it)
                return DataResult.Success(domainData)
            }
    }

    private suspend fun fetchPokemonName(pokemonId: Int): String {
        return listLocalDataSource.getPokemonNameById(pokemonId)
    }
}
