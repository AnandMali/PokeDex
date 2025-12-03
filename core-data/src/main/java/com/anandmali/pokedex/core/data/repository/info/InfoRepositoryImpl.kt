package com.anandmali.pokedex.core.data.repository.info

import com.anandmali.pokedex.core.data.Resource
import com.anandmali.pokedex.core.network.service.info.datasource.InfoRemoteDataSource
import com.anandmali.pokedex.core.network.service.info.model.PokeDetailsResponse
import com.anandmali.pokedex.core.network.util.DataError
import com.anandmali.pokedex.core.network.util.DataResult
import javax.inject.Inject

class InfoRepositoryImpl @Inject constructor(
    private val infoRemoteDataSource: InfoRemoteDataSource
) : InfoRepository {
    override suspend fun getPokemonInfo(name: String): Result<PokeDetailsResponse, DataError> {
        val response = try {
            infoRemoteDataSource.getPokemonInfo(name)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred. $e")
        }
        when (response) {
            is DataResult.Success -> return Resource.Success(response as PokeDetailsResponse)

        }
        response.mapSuccess {
            return Resource.Success(it)
        }

        return Resource.Error("An unknown error occurred.")
    }
}