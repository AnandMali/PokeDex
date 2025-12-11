package com.anandmali.pokedex.vm

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anandmali.pokedex.core.domain.pokemonDetails.usecase.DetailsUseCase
import com.anandmali.pokedex.state.DetailsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val detailsUseCase: DetailsUseCase,
    private val ioDispatcher: CoroutineDispatcher,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val pokemonId: Int = checkNotNull(savedStateHandle["pokemonId"])
    private val _uiState = MutableStateFlow<DetailsUiState>(DetailsUiState.Loading)
    val uiState: StateFlow<DetailsUiState> = _uiState

    init {
        fetchPokemonDetails()
    }

    private fun fetchPokemonDetails() {
        viewModelScope.launch(ioDispatcher) {
            _uiState.update { DetailsUiState.Loading }
            detailsUseCase.getDetails(pokemonId)
                .mapSuccess { details ->
                    _uiState.update {
                        DetailsUiState.Success(details)
                    }
                }
                .mapError { _ ->
                    _uiState.update {
                        DetailsUiState.Error("error")
                    }
                }
        }
    }
}