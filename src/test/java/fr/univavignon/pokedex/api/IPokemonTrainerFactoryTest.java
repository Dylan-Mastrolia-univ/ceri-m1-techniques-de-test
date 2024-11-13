package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory factory;
    private IPokedexFactory pokedexFactory;

    @Before
    public void init(){
        factory = new PokemonTrainerFactory();
        pokedexFactory = new PokedexFactory();
    }

    @Test
    public void testCreatePokemonTrainer() throws Exception{
        PokemonTrainer trainer = factory.createTrainer("TheTrain", Team.INSTINCT, pokedexFactory);
        assertNotNull(trainer);
        assertEquals("TheTrain", trainer.getName());
        assertEquals(Team.INSTINCT, trainer.getTeam());
        assertNotNull(trainer.getPokedex());
    }
}