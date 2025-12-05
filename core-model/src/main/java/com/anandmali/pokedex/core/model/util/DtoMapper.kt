package com.anandmali.pokedex.core.model.util

interface DtoMapper<Domain, Entity> {
    fun asEntity(domain: Domain): Entity
    fun asDomain(entity: Entity): Domain
}