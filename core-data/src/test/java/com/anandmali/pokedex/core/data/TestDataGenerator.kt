package com.anandmali.pokedex.core.data

import com.anandmali.pokedex.core.data.network.PokemonViewDTO


internal fun mockPokeViewData(
    name: String = "Bulbasaur",
    url: String = "https://pokeapi.co/api/v2/pokemon/1/",
    link: String = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png"
) = PokemonViewDTO(
    1,
    name,
    url,
    link
)