package com.anandmali.pokedex.nav

import androidx.navigation.NavHostController

class AppNavigator(private val navController: NavHostController) {
    fun openPokemonDetails(id: Int) {
        navController.navigate(Screen.PokemonDetails.createRoute(id))
    }
}