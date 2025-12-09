package com.anandmali.pokedex.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anandmali.pokedex.core.data.repository.list.ListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val listRepository: ListRepository
//    pokemonListStatus: Flow<PagingData<PokemonViewDTO>>
) : ViewModel() {

//    val pokemonListStatus: Flow<PagingData<PokemonViewDTO>> = pokemonListStatus

    init {
        viewModelScope.launch {
            getPokeList()
        }
    }

    private fun getPokeList() {
        viewModelScope.launch {
            listRepository.getPokeList()
                .collect {
                    println("Fetched list ====> $it")
                }
//                .map { data ->
//                    println("Fetched list ====> ${data.}")
//                    data.map {
//                        it.toViewData()
//                    }
//                }
        }
    }
}