package com.anandmali.pokedex.core.database.pokemonDetails.dataSource

import com.anandmali.pokedex.core.database.pokemonDetails.database.DetailsDao
import com.anandmali.pokedex.core.database.pokemonDetails.mapper.DetailsDomainMapper
import com.anandmali.pokedex.core.database.pokemonDetails.mapper.DetailsDtoMapper
import com.anandmali.pokedex.core.database.pokemonDetails.mapper.StatsDtoMapper
import com.anandmali.pokedex.core.database.pokemonDetails.mapper.TypesDtoMapper
import com.anandmali.pokedex.core.model.pokemonDetails.domain.PokemonDetailsDomainData
import com.anandmali.pokedex.core.model.pokemonDetails.network.PokemonDetailsResponse
import com.anandmali.pokedex.core.model.util.DataError
import com.anandmali.pokedex.core.model.util.DataResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DetailsLocalDataSourceImpl @Inject constructor(
    private val ioDispatcher: CoroutineDispatcher,
    private val detailsDao: DetailsDao
) : DetailsLocalDataSource {
    override suspend fun insertPokemonDetails(pokemonDetailsResponse: PokemonDetailsResponse) {
        withContext(ioDispatcher) {
            val detailsEntity = DetailsDtoMapper.map(pokemonDetailsResponse)
            val statsEntity = pokemonDetailsResponse.stats.map { item ->
                StatsDtoMapper(pokemonDetailsResponse.id).map(item)
            }

            val typesEntity = pokemonDetailsResponse.types.map { item ->
                TypesDtoMapper(pokemonDetailsResponse.id).map(item)
            }
            detailsDao.insertFullDetails(
                detailsEntity,
                statsEntity,
                typesEntity
            )
        }
    }

    override suspend fun getPokemonDetails(id: Int): DataResult<PokemonDetailsDomainData, DataError> {
        return withContext(ioDispatcher) {
            val result = detailsDao.getPokemonDetails(1)
            val domainData = DetailsDomainMapper.map(result)
            domainData.let {
                DataResult.Success(it)
            }
        }
    }
}