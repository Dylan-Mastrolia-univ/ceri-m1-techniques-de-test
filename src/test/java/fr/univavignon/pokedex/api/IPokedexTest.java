package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class IPokedexTest {
    private IPokedex pokedex;

    @Before
    public void init(){
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        IPokemonFactory pokemonFactory = new RocketPokemonFactory();
        pokedex = new Pokedex(metadataProvider, pokemonFactory);
    }

    @Test
    public void testAddPokemon() throws Exception{
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        int result = pokedex.addPokemon(pokemon);
        assertEquals(0, result);
    }

    @Test
    public void testGetPokemon() throws Exception{
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        pokedex.addPokemon(pokemon);
        Pokemon result = pokedex.getPokemon(0);
        assertNotNull(result);
        assertEquals(pokemon, result);
    }

    @Test
    public void testSize() {
        assertEquals(0, pokedex.size());
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56));
        pokemonList.add(new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1.0));

        for (Pokemon pokemon : pokemonList) {
            pokedex.addPokemon(pokemon);
        }

        List<Pokemon> result = pokedex.getPokemons();
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(pokemonList, result);
    }

    @Test
    public void testGetPokemonsWithOrder() {
        pokedex.addPokemon(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56));
        pokedex.addPokemon(new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1.0));

        Comparator<Pokemon> comparator = Comparator.comparing(Pokemon::getName);
        List<Pokemon> result = pokedex.getPokemons(comparator);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Aquali", result.get(0).getName());
    }
}