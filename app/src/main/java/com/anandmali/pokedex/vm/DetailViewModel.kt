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
import kotlinx.coroutines.flow.asStateFlow
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

    // This state will manage the main content (Loading, Success, Error)
    private val _uiState = MutableStateFlow<DetailsUiState>(DetailsUiState.Loading)
    val uiState: StateFlow<DetailsUiState> = _uiState

    // State for the top bar title
    private val _pokemonName = MutableStateFlow<String>("Details") // Default title
    val pokemonName: StateFlow<String> = _pokemonName.asStateFlow()

    init {
        // Get the name for the top bar immediately
        getPokemonName()

        // Get the full details for the main screen content
        getPokemonDetails()
    }

    private fun getPokemonName() {
        viewModelScope.launch(ioDispatcher) {
            // This is a placeholder for your actual UseCase call
            // val name = getPokemonNameUseCase(pokemonId)
            // For now, let's simulate getting it from the savedStateHandle if passed
            val nameFromNav = savedStateHandle.get<String>("pokemonName") ?: "Details"
            _pokemonName.value = nameFromNav.replaceFirstChar { it.uppercase() }
        }
    }

    private fun getPokemonDetails() {
        viewModelScope.launch(ioDispatcher) {
            // Set initial loading state
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