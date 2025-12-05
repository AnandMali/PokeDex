package com.anandmali.pokedex.core.data.repository.info

import com.anandmali.pokedex.core.data.Resource
import com.anandmali.pokedex.core.model.info.PokeDetailsResponse
import com.anandmali.pokedex.core.network.service.info.datasource.InfoRemoteDataSource
import javax.inject.Inject

class InfoRepositoryImpl @Inject constructor(
    private val infoRemoteDataSource: InfoRemoteDataSource
) : InfoRepository {
    override suspend fun getPokemonInfo(name: String): Resource<PokeDetailsResponse> {
        val response = try {
            infoRemoteDataSource.getPokemonInfo(name)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred. $e")
        }
        response.mapSuccess {
            return Resource.Success(it)
        }

        return Resource.Error("An unknown error occurred.")
    }
}