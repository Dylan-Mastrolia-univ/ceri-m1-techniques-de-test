package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class IPokedexFactoryTest {
    private IPokedexFactory factory;
    private IPokemonFactory pokemonFactory;
    private IPokemonMetadataProvider metadataProvider;

    @Before
    public void init(){
        factory = new PokedexFactory();
        pokemonFactory = new RocketPokemonFactory();
        metadataProvider = new PokemonMetadataProvider();
    }

    @Test
    public void testCreatePokedex() throws Exception{
        IPokedex pokedex = factory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(pokedex);
    }
}