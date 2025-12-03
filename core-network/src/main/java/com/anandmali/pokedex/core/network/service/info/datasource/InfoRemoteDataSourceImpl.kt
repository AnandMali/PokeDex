package com.anandmali.pokedex.core.network.service.info.datasource

import com.anandmali.pokedex.core.network.service.info.api.InfoApiService
import com.anandmali.pokedex.core.network.service.info.model.PokeDetailsResponse
import com.anandmali.pokedex.core.network.util.DataError
import com.anandmali.pokedex.core.network.util.DataResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class InfoRemoteDataSourceImpl @Inject constructor(
    private val ioDispatcher: CoroutineDispatcher,
    private val infoApiService: InfoApiService
) : InfoRemoteDataSource {
    override suspend fun getPokemonInfo(
        name: String
    ): DataResult<PokeDetailsResponse, DataError> {
        return try {
            withContext(ioDispatcher) {
                val response = infoApiService.getPokemonInfo(name)
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