package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider provider;

    @Before
    public void init(){
        provider = new PokemonMetadataProvider();
    }

    @Test
    public void testGetPokemonMetadata() throws Exception{
        PokemonMetadata metadata = provider.getPokemonMetadata(0);
        assertNotNull(metadata);
        assertEquals("Bulbizarre", metadata.getName());
        assertEquals(0, metadata.getIndex());
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());
        assertEquals(90, metadata.getStamina());
    }
}