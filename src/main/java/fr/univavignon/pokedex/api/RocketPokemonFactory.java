package fr.univavignon.pokedex.api;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RocketPokemonFactory implements IPokemonFactory {

	private static Map<Integer, String> index2name;
	static {
		Map<Integer, String> aMap = new HashMap<Integer, String>();
		aMap.put(-1, "Ash's Pikachu");
		aMap.put(0, "MISSINGNO");
		aMap.put(1, "Bulbasaur");
		index2name = Collections.unmodifiableMap(aMap);
	}

	private static int generateRandomStat(int min, int max) {
		Random rn = new Random();
		return rn.nextInt((max - min) + 1) + min;
	}

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		String name;
		if (!index2name.containsKey(index)) {
			name = index2name.get(0);
		} else {
			name = index2name.get(index);
		}
		int attack;
		int defense;
		int stamina;
		double iv;
		if (index < 0) {
			attack = 1000;
			defense = 1000;
			stamina = 1000;
			iv = 0;
		} else {
			attack = generateRandomStat(126, 141);
			defense = generateRandomStat(126, 141);
			stamina = generateRandomStat(90, 105);
			iv = new Random().nextDouble() * 100;
		}
		return new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);
	}
}

/* Rapport
 * Les valeurs attack, defense, stamina et iv
 * Ne généraient pas des valeurs correctes
 */