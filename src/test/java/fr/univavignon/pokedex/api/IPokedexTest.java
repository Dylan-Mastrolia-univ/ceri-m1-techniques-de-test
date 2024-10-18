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
}
