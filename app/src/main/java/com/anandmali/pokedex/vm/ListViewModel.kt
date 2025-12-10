package com.anandmali.pokedex.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anandmali.pokedex.core.domain.pokemonList.usecase.ListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val listUseCase: ListUseCase
) : ViewModel() {

    init {
        viewModelScope.launch {
            getPokemonList()
        }
    }

    private fun getPokemonList() {
        viewModelScope.launch {
            listUseCase.getPokemonList()
                .fold(
                    onSuccess = {
                        println("Fetched list ====> $it")
                    },
                    onError = {
                        println("Error ====> $it")
                    }
                )
        }
    }
}