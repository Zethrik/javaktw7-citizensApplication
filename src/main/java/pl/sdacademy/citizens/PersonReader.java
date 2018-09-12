package pl.sdacademy.citizens;

import pl.sdacademy.citizens.model.CsvFile;
import pl.sdacademy.citizens.model.CsvLine;
import pl.sdacademy.citizens.model.Person;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PersonReader {
    public List<Person> readFromFile(File fileName) throws ParseException {
        CsvFile csvLines = CsvFile.fromFile(fileName);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Person> persons = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (CsvLine csvLine : csvLines) {
            Person person = Person.builder(csvLine).build();
            if ((person.getName() != null && person.getName().length() >= 2)
                    && (person.getLastName() != null && person.getLastName().length() >= 2)
                    && (person.getSex().equals("F") || person.getSex().equals("M"))
                    && PeopleUtils.isNotFromTheFuture(person.getBirthDate())
                    && PeopleUtils.isAdult(person.getBirthDate())) {
                persons.add(person);
            }
        }
        long stop = System.currentTimeMillis();
        System.out.println("Converted " + persons.size() + " in " + (stop - start) + " ms");
        return persons;
    }
}
