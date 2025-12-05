package com.anandmali.pokedex.core.model.util

sealed interface DataError {
    data object NoData : DataError
    data object NoInternet : DataError
    data class TooManyRequests(val message: String) : DataError
    data class ServerError(val message: String) : DataError
    data class Unknown(val message: String) : DataError
}