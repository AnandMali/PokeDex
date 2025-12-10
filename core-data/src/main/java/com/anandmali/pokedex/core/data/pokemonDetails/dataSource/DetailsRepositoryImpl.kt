package com.anandmali.pokedex.core.data.pokemonDetails.dataSource

import com.anandmali.pokedex.core.data.pokemonDetails.mapper.DetailsDomainMapper
import com.anandmali.pokedex.core.database.pokemonDetails.dataSource.DetailsLocalDataSource
import com.anandmali.pokedex.core.model.pokemonDetails.domain.PokemonDetailsDomainData
import com.anandmali.pokedex.core.model.util.DataError
import com.anandmali.pokedex.core.model.util.DataResult
import com.anandmali.pokedex.core.network.service.pokemonDetails.datasource.DetailsRemoteDataSource
import javax.inject.Inject

class DetailsRepositoryImpl @Inject constructor(
    private val detailsRemoteDataSource: DetailsRemoteDataSource,
    private val detailsLocalDataSource: DetailsLocalDataSource
) : DetailsRepository {

    /**
     * Fetch from local source, check if success, else fetch from remote source
     * If remote success, clear local source and insert new data
     * Emit data with success or error
     */
    override suspend fun getPokemonDetails(
        pokemonId: Int,
        pokemonName: String
    ): DataResult<PokemonDetailsDomainData, DataError> {
        val cachedPokemonDetails = detailsLocalDataSource.getPokemonDetails(pokemonId)
        cachedPokemonDetails.fold(
            onSuccess = {
                return DataResult.Success(it)
            },
            onError = {
                return fetchFromRemote(pokemonName)
            }
        )
    }

    private suspend fun fetchFromRemote(pokemonName: String): DataResult<PokemonDetailsDomainData, DataError> {
        val remotePokemonDetails = detailsRemoteDataSource.getPokemonDetails(pokemonName)
        return remotePokemonDetails.fold(
            onSuccess = {
                detailsLocalDataSource.insertPokemonDetails(it)
                val domainData = DetailsDomainMapper.map(it)
                return DataResult.Success(domainData)
            },
            onError = {
                DataResult.Error(it)
            }
        )
    }
}