package fr.univavignon.pokedex.api;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class IPokedexTest {
    private IPokedex pokedex;

    @Before
    public void init(){
        pokedex = Mockito.mock(IPokedex.class);
    }

    @Test
    public void testAddPokemon() throws Exception{
        Pokemon pokemon = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,0.56);
        Mockito.when(pokedex.addPokemon(pokemon)).thenReturn(0);
        int result = pokedex.addPokemon(pokemon);
        assertEquals(result,0);
        Mockito.verify(pokedex).addPokemon(pokemon);


    }

    @Test
    public void testGetPokemon() throws Exception{
        Pokemon pokemon = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,0.56);
        Mockito.when(pokedex.getPokemon(0)).thenReturn(pokemon);
        Pokemon result = pokedex.getPokemon(0);
        assertNotNull(result);
        assertEquals(pokemon,result);
        Mockito.verify(pokedex).getPokemon(0);
    }

    @Test
    public void testSize() {
        Mockito.when(pokedex.size()).thenReturn(2);
        int size = pokedex.size();
        assertEquals(2, size);
        Mockito.verify(pokedex).size();
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> pokemonmlist = new ArrayList<>();
        pokemonmlist.add(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56));
        pokemonmlist.add(new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1.0));
        Mockito.when(pokedex.getPokemons()).thenReturn(pokemonmlist);
        List<Pokemon> result = pokedex.getPokemons();
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(pokemonmlist, result);
        Mockito.verify(pokedex).getPokemons();
    }

    @Test
    public void testGetPokemonsWithOrder() {
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56));
        pokemons.add(new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1.0));

        Comparator<Pokemon> comparator = Comparator.comparing(Pokemon::getName);
        Mockito.when(pokedex.getPokemons(comparator)).thenReturn(pokemons);
        List<Pokemon> result = pokedex.getPokemons(comparator);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(pokemons, result);
        Mockito.verify(pokedex).getPokemons(comparator);
    }
}
