package com.anandmali.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.anandmali.pokedex.nav.AppNavigator
import com.anandmali.pokedex.nav.NavigationGraph
import com.anandmali.pokedex.ui.theme.PokeDexTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokeDexTheme {
                val navController = rememberNavController()
                val navigator = remember(navController) {
                    AppNavigator(navController)
                }
                NavigationGraph(navController, navigator)
            }
        }
    }
}