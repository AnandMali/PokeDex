package com.anandmali.pokedex.core.network.service.list.dataSource

import com.anandmali.pokedex.core.network.service.list.api.ListApiService
import com.anandmali.pokedex.core.network.service.list.model.PokeList
import com.anandmali.pokedex.core.network.util.DataError
import com.anandmali.pokedex.core.network.util.DataResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class ListRemoteDataSourceImpl @Inject constructor(
    private val ioDispatcher: CoroutineDispatcher,
    private val listApiService: ListApiService
) : ListRemoteDataSource {
    override suspend fun getPokeList(
        limit: Int,
        offset: Int
    ): DataResult<PokeList, DataError> {
        return try {
            withContext(ioDispatcher) {
                val response = listApiService.getPokeList(limit, offset)
                if (response.results.isNotEmpty()) {
                    DataResult.Success(response)
                } else
                    DataResult.Error(DataError.NoData)
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