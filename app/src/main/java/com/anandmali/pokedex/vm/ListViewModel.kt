package com.anandmali.pokedex.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anandmali.pokedex.core.domain.pokemonList.usecase.ListUseCase
import com.anandmali.pokedex.state.ListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val listUseCase: ListUseCase,
    private val ioDispatcher: CoroutineDispatcher,
) : ViewModel() {

    private val _uiState = MutableStateFlow<ListUiState>(ListUiState.Loading)
    val uiState: StateFlow<ListUiState> = _uiState

    init {
        getPokemonList()
    }

    private fun getPokemonList() {
        viewModelScope.launch(ioDispatcher) {
            _uiState.update {
                ListUiState.Loading
            }
            listUseCase.getPokemonList()
                .mapSuccess { list ->
                    _uiState.update {
                        ListUiState.Success(list)
                    }
                }
                .mapError { error ->
                    _uiState.update {
                        ListUiState.Error("error")
                        // TODO implement proper error handling
                    }
                }
        }
    }
}