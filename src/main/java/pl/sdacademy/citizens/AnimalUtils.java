package pl.sdacademy.citizens;

import pl.sdacademy.citizens.model.Animal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimalUtils {
    public static void countAnimalsBySpecies (List<Animal> animals) {
        Map<String, Integer> animalsMap = new HashMap<>();
        for (Animal animal : animals) {
            if (!animalsMap.keySet().contains(animal.getSpecie())) {
                animalsMap.put(animal.getSpecie(), 1);
            } else {
                animalsMap.computeIfPresent(animal.getSpecie(), (k, v) -> v + 1);
            }
        }

        for (String specie : animalsMap.keySet()) {
            Integer amountOfAnimals = animalsMap.get(specie);
            System.out.println(specie + " -> " + amountOfAnimals);
        }
    }
}
