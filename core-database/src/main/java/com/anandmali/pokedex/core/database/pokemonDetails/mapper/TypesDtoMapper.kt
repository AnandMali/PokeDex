package com.anandmali.pokedex.core.database.pokemonDetails.mapper

import com.anandmali.pokedex.core.database.pokemonDetails.model.TypesEntity
import com.anandmali.pokedex.core.common.pokemonDetails.network.Type
import com.anandmali.pokedex.core.common.util.DtoMapper

class TypesDtoMapper(private val primaryId: Int) :
    DtoMapper<Type, TypesEntity> {
    override fun map(input: Type): TypesEntity {
        return with(input) {
            TypesEntity(
                pokemonId = primaryId,
                name = type.name
            )
        }
    }
}