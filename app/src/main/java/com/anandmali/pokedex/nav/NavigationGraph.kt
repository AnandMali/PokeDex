package com.anandmali.pokedex.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.anandmali.pokedex.screens.DetailsScreen
import com.anandmali.pokedex.screens.ListScreen

@Composable
fun NavigationGraph(navController: NavHostController, navigator: AppNavigator) {
    NavHost(
        navController = navController,
        startDestination = Screen.PokemonList.route
    ) {
        composable(Screen.PokemonList.route) {
            ListScreen(navigator)
        }

        composable(
            route = Screen.PokemonDetails.route,
            arguments = listOf(
                navArgument("pokemonId") { type = NavType.IntType }
            )
        ) {
            DetailsScreen(
                navController = navController
            )
        }
    }
}