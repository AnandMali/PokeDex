package com.anandmali.pokedex.vm

import androidx.lifecycle.ViewModel
import com.anandmali.pokedex.core.data.pokemonDetails.dataSource.DetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val detailsRepository: DetailsRepository
) : ViewModel() {
    suspend fun getPokemonDetails(pokemonName: String) {
        //  TODO fetch pokemon details
    }
}