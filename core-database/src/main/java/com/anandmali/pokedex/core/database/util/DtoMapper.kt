package com.anandmali.pokedex.core.database.util

interface DtoMapper<Input, Output> {
    fun map(input: Input): Output
}