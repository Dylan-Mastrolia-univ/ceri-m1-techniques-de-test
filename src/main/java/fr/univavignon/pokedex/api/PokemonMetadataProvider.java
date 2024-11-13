package fr.univavignon.pokedex.api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    private Map<Integer, PokemonMetadata> metadataMap;

    public PokemonMetadataProvider() {
        metadataMap = new HashMap<>();
        loadMetadataFromCSV("pokemon_metadata.csv");
    }

    private void loadMetadataFromCSV(String filePath) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int index = Integer.parseInt(values[0]);
                String name = values[1];
                int attack = Integer.parseInt(values[2]);
                int defense = Integer.parseInt(values[3]);
                int stamina = Integer.parseInt(values[4]);

                PokemonMetadata metadata = new PokemonMetadata(index, name, attack, defense, stamina);
                metadataMap.put(index, metadata);
            }
        } catch (IOException e) {
            System.err.println("Erreur ouverture csv");
        }
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (!metadataMap.containsKey(index)) {
            throw new PokedexException("Ce pokemon existe pas");
        }
        return metadataMap.get(index);
    }
}