package com.anandmali.pokedex.core.data.repository.info

import com.anandmali.pokedex.core.data.Resource
import com.anandmali.pokedex.core.database.pokemonDetails.dataSource.DetailsLocalDataSource
import com.anandmali.pokedex.core.model.pokemonDetails.network.PokemonDetailsResponse
import com.anandmali.pokedex.core.network.service.info.datasource.InfoRemoteDataSource
import javax.inject.Inject

class InfoRepositoryImpl @Inject constructor(
    private val infoRemoteDataSource: InfoRemoteDataSource,
    private val detailsLocalDataSource: DetailsLocalDataSource
) : InfoRepository {
    override suspend fun getPokemonInfo(name: String): Resource<PokemonDetailsResponse> {
        val response = try {
            infoRemoteDataSource.getPokemonInfo(name)
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