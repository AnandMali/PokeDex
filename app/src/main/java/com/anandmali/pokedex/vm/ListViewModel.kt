package com.anandmali.pokedex.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anandmali.pokedex.core.data.pokemonList.dataSource.ListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val listRepository: ListRepository
) : ViewModel() {

    init {
        viewModelScope.launch {
            getPokemonList()
        }
    }

    private fun getPokemonList() {
        viewModelScope.launch {
            listRepository.getPokemonList()
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