package com.anandmali.pokedex.core.common.util

interface DtoMapper<Input, Output> {
    fun map(input: Input): Output
}