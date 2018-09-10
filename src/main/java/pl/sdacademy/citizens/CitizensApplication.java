package pl.sdacademy.citizens;

import pl.sdacademy.citizens.model.Person;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.*;

public class CitizensApplication {

    private PersonReader personReader;

    public CitizensApplication() {
        this.personReader = new PersonReader();
    }

    public void process() throws ParseException {
        File personFile = new File(getClass().getClassLoader().getResource("person.csv").getFile());
        List<Person> people = personReader.readFromFile(personFile);

        Map<String, Long> nameSummary = PeopleUtils.createNameSummary(people);
        // sample: how to print results to the console
//        for (Map.Entry<String, Long> nameCount : nameSummary.entrySet()) {
//            System.out.println("There are " + nameCount.getValue() + " persons with name " + nameCount.getKey());
//        }
//        Map<String, Long> countedByLastName = countPeopleByLastName(people);
//        for (String lastName : countedByLastName.keySet()) {
//            Long amountOfPeople = countedByLastName.get(lastName);
//            System.out.println(lastName + " -> " + amountOfPeople);
//        }

//        Map<String, List<Person>> groupedByName = groupPeopleByName(people);
//        for (String name : groupedByName.keySet()) {
//            List<Person> listOfPersons = groupedByName.get(name);
//            System.out.println(name + " -> " + listOfPersons);
//        }

//        System.out.println(countPeopleOver35(people));
        System.out.println(PeopleUtils.countPeopleWithAgeBetween(35, 55, people));
        System.out.println(PeopleUtils.countPeopleAbleToRetairement(people));
    }






}
