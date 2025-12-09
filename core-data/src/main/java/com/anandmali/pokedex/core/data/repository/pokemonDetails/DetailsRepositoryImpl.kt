package com.anandmali.pokedex.core.data.repository.pokemonDetails

import com.anandmali.pokedex.core.data.Resource
import com.anandmali.pokedex.core.database.pokemonDetails.dataSource.DetailsLocalDataSource
import com.anandmali.pokedex.core.model.pokemonDetails.network.PokemonDetailsResponse
import com.anandmali.pokedex.core.network.service.pokemonDetails.datasource.DetailsRemoteDataSource
import javax.inject.Inject

class DetailsRepositoryImpl @Inject constructor(
    private val detailsRemoteDataSource: DetailsRemoteDataSource,
    private val detailsLocalDataSource: DetailsLocalDataSource
) : DetailsRepository {
    override suspend fun getPokemonInfo(name: String): Resource<PokemonDetailsResponse> {
        val response = try {
            detailsRemoteDataSource.getPokemonInfo(name)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred. $e")
        }
        response.mapSuccess {
            detailsLocalDataSource.insertPokemonDetails(it)
            return Resource.Success(it)
        }

        return Resource.Error("An unknown error occurred.")
    }
}