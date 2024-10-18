package fr.univavignon.pokedex.api;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexTest {
    private IPokedex pokedex;

    @Before
    public void init(){
        pokedex = Mockito.mock(IPokedex.class);
    }

    @Test
    public void testAddPokemon() throws Exception{
        Pokemon pokemon = new Pokemon(1,"Pika",100,120,200,5,40,20,30,43.00);
        Mockito.when(pokedex.addPokemon(pokemon)).thenReturn(1);
        int result = pokedex.addPokemon(pokemon);
        assertEquals(result,1);
        Mockito.verify(pokedex).addPokemon(pokemon);


    }

    @Test
    public void testGetPokemon() throws Exception{
        Pokemon pokemon = new Pokemon(1,"Pika",100,120,200,5,40,20,30,43.00);
        Mockito.when(pokedex.getPokemon(1)).thenReturn(pokemon);
        Pokemon result = pokedex.getPokemon(1);
        assertNotNull(result);
        assertEquals(pokemon,result);
        Mockito.verify(pokedex).getPokemon(1);
    }
}
