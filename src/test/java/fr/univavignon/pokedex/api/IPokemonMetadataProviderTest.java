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
        PokemonMetadata metadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        Mockito.when(provider.getPokemonMetadata(0)).thenReturn(metadata);
        PokemonMetadata result = provider.getPokemonMetadata(0);
        assertNotNull(result);
        assertEquals("Bulbizarre", result.getName());
        assertEquals(0,result.getIndex());
        assertEquals(126,result.getAttack());
        assertEquals(126,result.getDefense());
        assertEquals(90,result.getStamina());

    }

}
