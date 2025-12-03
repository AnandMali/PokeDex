package com.anandmali.pokedex.presentation.vm

import androidx.lifecycle.ViewModel
import com.anandmali.pokedex.core.data.Resource
import com.anandmali.pokedex.core.data.remote.response.PokeDetailsResponse
import com.anandmali.pokedex.core.data.repository.InfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val remoteRepository: InfoRepository
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<PokeDetailsResponse> {
        return remoteRepository.getPokemonInfo(pokemonName)
    }
}