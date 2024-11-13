package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {


    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        try {
            IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
            PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);
            String name = metadata.getName();
            int baseAttack = metadata.getAttack();
            int baseDefense = metadata.getDefense();
            int baseStamina = metadata.getStamina();


            double ivPercentage = ((baseAttack + baseDefense + baseStamina) / 45.0) * 100;

            return new Pokemon(index, name, cp, hp, dust, candy, baseAttack, baseDefense, baseStamina, ivPercentage);
        } catch (PokedexException e) {
            System.err.println("Metadata inconnu: " + e.getMessage());
            return null;
        }
    }
}