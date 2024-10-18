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
        Pokemon pokemon = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,0.56);
        Mockito.when(factory.createPokemon(0,613,64,4000,4)).thenReturn(pokemon);
        Pokemon result = factory.createPokemon(0,613,64,4000,4);
        assertNotNull(result);
        assertEquals(0,result.getIndex());
        assertEquals(613, result.getCp());
        assertEquals(64, result.getHp());
        assertEquals(4000,result.getDust());
        assertEquals(4,result.getCandy());
        assertEquals(0.56,result.getIv(),0);


    }
}
