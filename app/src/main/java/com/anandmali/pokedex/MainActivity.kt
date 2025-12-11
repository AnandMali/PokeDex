package com.anandmali.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.anandmali.pokedex.screens.DetailsScreen
import com.anandmali.pokedex.screens.ListScreen
import com.anandmali.pokedex.ui.theme.PokeDexTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokeDexTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "pokemonList"
                ) {
                    composable(
                        route = "PokemonList"
                    ) {
                        ListScreen(navController)
                    }
                    composable(
                        route = "pokemonDetails/{pokemonId}",
                        arguments = listOf(
                            navArgument("pokemonId") {
                                type = NavType.IntType
                            }
                        )
                    ) {
                        val pokemonName = remember {
                            it.arguments?.getString("pokeName")
                        }
                        DetailsScreen(
                            pokemonName = pokemonName?.lowercase(Locale.ROOT) ?: "",
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}