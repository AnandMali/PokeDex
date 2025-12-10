package com.anandmali.pokedex.core.model.util

interface DtoMapper<Input, Output> {
    fun map(input: Input): Output
}