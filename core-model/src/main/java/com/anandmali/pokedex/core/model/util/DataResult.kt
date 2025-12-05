package com.anandmali.pokedex.core.model.util

sealed class DataResult<out L, out R> {

    data class Success<out L>(val value: L) : DataResult<L, Nothing>()
    data class Error<out R>(val value: R) : DataResult<Nothing, R>()

    /**
     * Maps a Left value using the given function, keeping Right untouched.
     */
    inline fun <T> mapSuccess(transform: (L) -> T): DataResult<T, R> = when (this) {
        is Success -> Success(transform(value))
        is Error -> this
    }

    /**
     * Maps a Right value using the given function, keeping Left untouched.
     */
    inline fun <T> mapError(transform: (R) -> T): DataResult<L, T> = when (this) {
        is Error -> Error(transform(value))
        is Success -> this
    }

}
