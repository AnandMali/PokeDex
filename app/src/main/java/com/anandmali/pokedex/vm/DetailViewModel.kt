package com.anandmali.pokedex.vm

import androidx.lifecycle.ViewModel
import com.anandmali.pokedex.core.domain.pokemonDetails.usecase.DetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val detailsUseCase: DetailsUseCase
) : ViewModel() {
    suspend fun getPokemonDetails(pokemonName: String) {
        //  TODO fetch pokemon details
    }
}