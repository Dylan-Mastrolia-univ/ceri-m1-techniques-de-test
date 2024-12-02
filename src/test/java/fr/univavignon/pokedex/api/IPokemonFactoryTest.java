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

    @Test
    public void testMissingNoName() {
        Pokemon pokemon = factory.createPokemon(0, 0, 0, 0, 0);

        assertNotNull(pokemon);
        assertEquals("MISSINGNO", pokemon.getName());
    }

    @Test
    public void testCreatePokemonIndexNegatif() throws Exception {
        Pokemon pokemon = factory.createPokemon(-1, 500, 50, 1000, 5);

        assertNotNull(pokemon);
        assertEquals( -1, pokemon.getIndex());
        assertEquals( 500, pokemon.getCp());
        assertEquals(50, pokemon.getHp());
        assertEquals( 1000, pokemon.getDust());
        assertEquals( 5, pokemon.getCandy());

        assertEquals(1000, pokemon.getAttack());
        assertEquals(1000, pokemon.getDefense());
        assertEquals( 1000, pokemon.getStamina());
        assertEquals(0, pokemon.getIv(), 0);
    }

    @Test
    public void testCreatePokemonIndexInconnu() throws Exception {
        Pokemon pokemon = factory.createPokemon(999, 300, 30, 100, 1);

        assertNotNull(pokemon);
        assertEquals( 999, pokemon.getIndex());
        assertEquals( 300, pokemon.getCp());
        assertEquals( 30, pokemon.getHp());
        assertEquals( 100, pokemon.getDust());
        assertEquals( 1, pokemon.getCandy());

        assertTrue(pokemon.getAttack() >= 126 && pokemon.getAttack() <= 141);
        assertTrue( pokemon.getDefense() >= 126 && pokemon.getDefense() <= 141);
        assertTrue(pokemon.getStamina() >= 90 && pokemon.getStamina() <= 105);

        assertTrue( pokemon.getIv() >= 0 && pokemon.getIv() <= 100);
    }

}