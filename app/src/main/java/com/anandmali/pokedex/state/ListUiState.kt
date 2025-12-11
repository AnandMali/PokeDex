package com.anandmali.pokedex.state

import com.anandmali.pokedex.core.domain.pokemonList.model.ListItemViewData

sealed class ListUiState {
    object Loading : ListUiState()
    data class Success(val pokemonList: List<ListItemViewData>) : ListUiState()
    data class Error(val message: String) : ListUiState()
}