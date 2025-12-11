package com.anandmali.pokedex.state

import com.anandmali.pokedex.core.domain.pokemonDetails.model.DetailsViewData

sealed class DetailsUiState {
    object Loading : DetailsUiState()
    data class Success(val pokemonDetails: DetailsViewData) : DetailsUiState()
    data class Error(val message: String) : DetailsUiState()
}