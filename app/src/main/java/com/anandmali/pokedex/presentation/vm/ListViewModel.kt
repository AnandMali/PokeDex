package com.anandmali.pokedex.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.anandmali.pokedex.core.data.model.PokemonViewDTO
import com.anandmali.pokedex.core.data.model.toViewData
import com.anandmali.pokedex.core.data.repository.InfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val infoRepository: InfoRepository
) : ViewModel() {

    val pokemonListStatus: Flow<PagingData<PokemonViewDTO>>

    init {
        pokemonListStatus = getPokeList().cachedIn(viewModelScope)
    }

    private fun getPokeList(): Flow<PagingData<PokemonViewDTO>> {
        return infoRepository.getPokeList()
            .map { data ->
                data.map {
                    it.toViewData()
                }
            }
    }
}