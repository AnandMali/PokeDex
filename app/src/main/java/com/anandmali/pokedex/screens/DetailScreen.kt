@file:OptIn(ExperimentalMaterial3Api::class)

package com.anandmali.pokedex.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.anandmali.pokedex.core.domain.pokemonDetails.model.DetailsViewData
import com.anandmali.pokedex.model.createImageUrl
import com.anandmali.pokedex.state.DetailsUiState
import com.anandmali.pokedex.ui.components.PokemonBaseStats
import com.anandmali.pokedex.ui.components.PokemonSize
import com.anandmali.pokedex.ui.components.PokemonType
import com.anandmali.pokedex.vm.DetailViewModel

@Composable
fun DetailsScreen(
    pokemonName: String,
    navController: NavController,
    viewModel: DetailViewModel = hiltViewModel()
) {
    val detailsUiState = viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                },
                title = {
                    Text(
                        text = pokemonName.replaceFirstChar { it.uppercaseChar() },
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        },
        modifier = Modifier.background(MaterialTheme.colorScheme.onBackground)
    ) { paddingValues ->
        PokemonDetailStateWrapper(
            pokemonDetails = detailsUiState.value,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        )
    }
}


@Composable
fun PokemonDetailStateWrapper(
    pokemonDetails: DetailsUiState,
    modifier: Modifier = Modifier
) {
    when (pokemonDetails) {
        is DetailsUiState.Success -> {
            PokemonDetailSection(
                pokemonDetails = pokemonDetails.pokemonDetails,
                modifier = modifier
            )
        }

        is DetailsUiState.Error -> {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = pokemonDetails.message,
                    color = Color.Red,
                    modifier = modifier
                )
            }
        }

        is DetailsUiState.Loading -> {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.secondary,
                )
            }
        }
    }
}

@Composable
fun PokemonDetailSection(
    pokemonDetails: DetailsViewData,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(createImageUrl(pokemonDetails.id))
                .build(),
            contentDescription = pokemonDetails.name,
            contentScale = ContentScale.Fit,
            modifier = Modifier.aspectRatio(1.2f)
        )

        PokemonType(types = pokemonDetails.types)

        PokemonSize(
            pokemonWeight = pokemonDetails.weight,
            pokemonHeight = pokemonDetails.height
        )
        PokemonBaseStats(
            pokemonDetails = pokemonDetails,
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth(.9f)
        )
    }
}