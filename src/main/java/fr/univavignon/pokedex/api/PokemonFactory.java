package fr.univavignon.pokedex.api;

import java.util.Random;

public class PokemonFactory implements IPokemonFactory {

    private static final Random random = new Random();

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        try {
            IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
            PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);

            String name = metadata.getName();
            int baseAttack = metadata.getAttack();
            int baseDefense = metadata.getDefense();
            int baseStamina = metadata.getStamina();

            int randomAttack = random.nextInt(16);
            int randomDefense = random.nextInt(16);
            int randomStamina = random.nextInt(16);

            int attack = baseAttack + randomAttack;
            int defense = baseDefense + randomDefense;
            int stamina = baseStamina + randomStamina;

            double ivPercentage = ((randomAttack + randomDefense + randomStamina) / 45.0) * 100;

            return new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, ivPercentage);
        } catch (PokedexException e) {
            System.err.println("metadata Inconnu: " + e.getMessage());
            return null;
        }
    }
}