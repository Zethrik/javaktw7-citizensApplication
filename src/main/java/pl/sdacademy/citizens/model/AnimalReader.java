package pl.sdacademy.citizens.model;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class AnimalReader {
    public List<Animal> readFromFile(File fileName) throws ParseException {
        CsvFile csvLines = CsvFile.fromFile(fileName);
        List<Animal> animals = new ArrayList<>();
//        long start = System.currentTimeMillis();
        for (CsvLine csvLine : csvLines) {
            animals.add(Animal.builder(csvLine).build());
        }
//        long stop = System.currentTimeMillis();
//        System.out.println("Converted " + animals.size() + " in " + (stop - start) + " ms");
        return animals;
    }
}
