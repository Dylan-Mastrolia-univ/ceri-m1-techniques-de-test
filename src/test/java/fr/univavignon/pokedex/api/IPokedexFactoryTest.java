package fr.univavignon.pokedex.api;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexFactoryTest {
    private IPokedexFactory factory;
    private IPokemonFactory pokemonFactory;
    private IPokemonMetadataProvider metadataProvider;

    @Before
    public void init(){
        factory = Mockito.mock(IPokedexFactory.class);
        pokemonFactory = Mockito.mock(IPokemonFactory.class);
        metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
    }

    @Test
    public void testCreatePokedex() throws Exception{
        IPokedex pokedex = Mockito.mock(IPokedex.class);
        Mockito.when(factory.createPokedex(metadataProvider,pokemonFactory)).thenReturn(pokedex);
        IPokedex result = factory.createPokedex(metadataProvider,pokemonFactory);
        assertNotNull(result);
        Mockito.verify(factory).createPokedex(metadataProvider,pokemonFactory);




    }
}
