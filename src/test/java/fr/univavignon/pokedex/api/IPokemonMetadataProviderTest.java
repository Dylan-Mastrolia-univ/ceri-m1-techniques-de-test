package fr.univavignon.pokedex.api;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider provider;

    @Before
    public void init(){
        provider = Mockito.mock(IPokemonMetadataProvider.class);
    }

    @Test
    public void testGetPokemonMetadata() throws Exception{
        PokemonMetadata metadata = new PokemonMetadata(1, "Pika", 120, 120, 100);
        Mockito.when(provider.getPokemonMetadata(1)).thenReturn(metadata);
        PokemonMetadata result = provider.getPokemonMetadata(1);
        assertNotNull(result);
        assertEquals("Pika", result.getName());

    }

}
