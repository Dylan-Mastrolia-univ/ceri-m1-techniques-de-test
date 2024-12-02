package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class IPokemonFactoryTest {

    private IPokemonFactory factory;

    @Before
    public void init(){
        factory = new RocketPokemonFactory();
    }

    @Test
    public void testCreatePokemon() throws Exception {
        Pokemon pokemon = factory.createPokemon(0, 613, 64, 4000, 4);

        assertNotNull(pokemon);
        assertEquals(0, pokemon.getIndex());
        assertEquals(613, pokemon.getCp());
        assertEquals(64, pokemon.getHp());
        assertEquals(4000, pokemon.getDust());
        assertEquals(4, pokemon.getCandy());

        assertTrue(pokemon.getAttack() >= 126 && pokemon.getAttack() <= 141);
        assertTrue(pokemon.getDefense() >= 126 && pokemon.getDefense() <= 141);
        assertTrue(pokemon.getStamina() >= 90 && pokemon.getStamina() <= 105);

        assertTrue(pokemon.getIv() >= 0 && pokemon.getIv() <= 100);
    }

    @Test
    public void testRandomStatsRange() {
        for (int i = 0; i < 1000; i++) {
            Pokemon pokemon = factory.createPokemon(0, 500, 50, 2000, 2);

            assertTrue(pokemon.getAttack() >= 126 && pokemon.getAttack() <= 141);
            assertTrue( pokemon.getDefense() >= 126 && pokemon.getDefense() <= 141);
            assertTrue( pokemon.getStamina() >= 90 && pokemon.getStamina() <= 105);
            assertTrue( pokemon.getIv() >= 0 && pokemon.getIv() <= 100);
        }
    }
}