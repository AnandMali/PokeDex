package com.anandmali.pokedex.presentation.vm

import androidx.lifecycle.ViewModel
import com.anandmali.pokedex.core.data.repository.pokemonDetails.DetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val detailsRepository: DetailsRepository
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String) {
        //  TODO fetch pokemon details
    }
}