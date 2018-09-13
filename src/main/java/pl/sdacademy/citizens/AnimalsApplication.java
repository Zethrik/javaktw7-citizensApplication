package pl.sdacademy.citizens;

import pl.sdacademy.citizens.model.Animal;
import pl.sdacademy.citizens.model.AnimalReader;

import java.io.File;
import java.text.ParseException;
import java.util.List;

public class AnimalsApplication {
    private AnimalReader animalReader;

    public AnimalsApplication() {
        this.animalReader = new AnimalReader();
    }

    public void process() throws ParseException {
        File animalFile = new File(getClass().getClassLoader().getResource("animal.csv").getFile());
        List<Animal> animals = animalReader.readFromFile(animalFile);
    }
}
