package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory factory;
    private IPokedexFactory pokedexFactory;
    private IPokedex pokedex;


    @Before
    public void init(){
        factory = Mockito.mock(IPokemonTrainerFactory.class);
        pokedexFactory = Mockito.mock(IPokedexFactory.class);
        pokedex = Mockito.mock(IPokedex.class);

    }

    @Test
    public void testCreatePokemonTrainer() throws Exception{
        PokemonTrainer trainer = new PokemonTrainer("TheTrain",Team.INSTINCT,pokedex);
        Mockito.when(pokedexFactory.createPokedex(Mockito.any(), Mockito.any())).thenReturn(pokedex);
        Mockito.when(factory.createTrainer("TheTrain",Team.INSTINCT,pokedexFactory)).thenReturn(trainer);
        PokemonTrainer result = factory.createTrainer("TheTrain",Team.INSTINCT,pokedexFactory);
        assertNotNull(result);
        assertEquals("TheTrain", result.getName());
    }
}
