package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IPokemonFactoryTest {
    private IPokemonFactory factory;

    @Before
    public void init() {
        factory = new RocketPokemonFactory();
    }

    @Test
    public void testCreatePokemon() throws Exception {
        Pokemon result = factory.createPokemon(0, 613, 64, 4000, 4);

        assertNotNull(result);

        assertEquals(0, result.getIndex());
        assertEquals("MISSINGNO", result.getName());
        assertEquals(613, result.getCp());
        assertEquals(64, result.getHp());
        assertEquals(4000, result.getDust());
        assertEquals(4, result.getCandy());


        assertEquals(1.0, result.getIv(), 0);
    }
}