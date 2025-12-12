package com.anandmali.pokedex.core.network.service.pokemonDetails.datasource

import com.anandmali.pokedex.core.common.pokemonDetails.network.PokemonDetailsResponse
import com.anandmali.pokedex.core.network.service.pokemonDetails.api.DetailsApiService
import com.anandmali.pokedex.core.common.util.DataError
import com.anandmali.pokedex.core.common.util.DataResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class DetailsRemoteDataSourceImpl @Inject constructor(
    private val ioDispatcher: CoroutineDispatcher,
    private val detailsApiService: DetailsApiService
) : DetailsRemoteDataSource {
    override suspend fun fetchPokemonDetails(
        name: String
    ): DataResult<PokemonDetailsResponse, DataError> {
        return try {
            withContext(ioDispatcher) {
                val response = detailsApiService.getPokemonDetails(name)
                DataResult.Success(response)
            }
        } catch (e: HttpException) {
            val error = when (e.code()) {
                429 -> DataError.TooManyRequests("Too many requests")
                in 500..599 -> DataError.ServerError("Internal Server Error")
                else -> DataError.Unknown("Unknown Error")
            }
            return DataResult.Error(error)
        } catch (e: IOException) {
            print("IOException while getting lists: $e")
            DataResult.Error(DataError.NoInternet)
        }
    }
}