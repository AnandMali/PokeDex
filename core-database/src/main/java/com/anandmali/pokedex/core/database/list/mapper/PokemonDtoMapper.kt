package com.anandmali.pokedex.core.database.list.mapper

import com.anandmali.pokedex.core.database.list.model.PokemonEntity
import com.anandmali.pokedex.core.model.list.Pokemon
import com.anandmali.pokedex.core.model.util.DtoMapper

object PokemonDtoMapper : DtoMapper<List<Pokemon>, List<PokemonEntity>> {
    override fun asEntity(domain: List<Pokemon>): List<PokemonEntity> {
        return domain.map { pokemon ->
            PokemonEntity(
                name = pokemon.name,
                url = pokemon.url,
            )
        }
    }

    override fun asDomain(entity: List<PokemonEntity>): List<Pokemon> {
        return entity.map { pokemonEntity ->
            Pokemon(
                name = pokemonEntity.name,
                url = pokemonEntity.url,
            )
        }
    }
}

fun List<Pokemon>.asEntity(): List<PokemonEntity> {
    return PokemonDtoMapper.asEntity(this)
}

fun List<PokemonEntity>?.asDomain(): List<Pokemon> {
    return PokemonDtoMapper.asDomain(this.orEmpty())
}
