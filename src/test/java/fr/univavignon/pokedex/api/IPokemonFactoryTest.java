package fr.univavignon.pokedex.api;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonFactoryTest {
    private IPokemonFactory factory;

    @Before
    public void init(){
        factory = Mockito.mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokemon() throws Exception{
        Pokemon pokemon = new Pokemon(1,"Pika",100,120,200,5,40,20,30,43.00);
        Mockito.when(factory.createPokemon(1,5,40,20,30)).thenReturn(pokemon);
        Pokemon result = factory.createPokemon(1,5,40,20,30);
        assertNotNull(result);
        assertEquals(5, result.getCp());
    }
}
