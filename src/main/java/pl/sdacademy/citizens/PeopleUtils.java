package pl.sdacademy.citizens;

import pl.sdacademy.citizens.model.Animal;
import pl.sdacademy.citizens.model.Person;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.*;

public class PeopleUtils {
    public static Map<String, Long> countPeopleByLastName(List<Person> people) {
        Map<String, Long> countedByLastName = new HashMap<>();
        for (Person person : people) {
            String lastName = person.getLastName();
            if (countedByLastName.containsKey(lastName)) {
                Long amountOfPeople = countedByLastName.get(lastName);
                amountOfPeople++;
                countedByLastName.put(lastName, amountOfPeople);
            } else {
                countedByLastName.put(lastName, 1L);
            }
        }
        return countedByLastName;
    }

    public static Map<String, List<Person>> groupPeopleByName(List<Person> people) {
        Map<String, List<Person>> groupedByName = new HashMap<>();

        for (Person person : people) {
            String name = person.getName();
            if (groupedByName.containsKey(name)) {
                List<Person> listOfPersons = groupedByName.get(name);
                listOfPersons.add(person);
            } else {
                List<Person> listOfPersons = new ArrayList<>();
                listOfPersons.add(person);
                groupedByName.put(name, listOfPersons);
            }
        }
        return groupedByName;
    }

    public static Map<String, Long> createNameSummary(List<Person> people) {
        Map<String, Long> nameCount = new HashMap<>();
        for (Person person : people) {
            String name = person.getName();
            Long peopleWithTheSameNameCount = nameCount.getOrDefault(name, 0L);
            peopleWithTheSameNameCount++;
            nameCount.put(name, peopleWithTheSameNameCount);
        }
        return nameCount;
    }

//    private Long countPeopleOver35(List<Person> people) throws ParseException {
//        Long peopleOver35AndUnder55 = 0L;
//
//        for (Person person : people) {
//            Date birthDate = person.getBirthDate();
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//            Date firstAge = dateFormat.parse("1982-09-09");
//            Date secondAge = dateFormat.parse("1962-09-09");
//
//            if (birthDate.compareTo(firstAge) <= 0 && birthDate.compareTo(secondAge) >= 0 ) {
//                peopleOver35AndUnder55++;
//            }
//        }
//        return peopleOver35AndUnder55;
//    }

    public static Long countPeopleWithAgeBetween(int youngestAge, int oldestAge, List<Person> people) {
        Date youngestValidDate = Date.from(LocalDate.now()
                .minusYears(youngestAge)
                .atStartOfDay()
                .toInstant(ZoneOffset.UTC));
        Date oldestValidDate = Date.from(LocalDate.now()
                .minusYears(oldestAge)
                .atStartOfDay()
                .toInstant(ZoneOffset.UTC));
        Long amountOfPeopleWithAge = 0L;
        for (Person person : people) {
            Date birthDate = person.getBirthDate();
            if (birthDate.after(oldestValidDate) && birthDate.before(youngestValidDate)) {
                amountOfPeopleWithAge++;
            }
        }
        return amountOfPeopleWithAge;
    }

    public static Long countPeopleAbleToRetairement(List<Person> people) throws ParseException {
        Date maleValidDate = Date.from(LocalDate.now()
                .minusYears(65)
                .atStartOfDay()
                .toInstant(ZoneOffset.UTC));
        Date femaleValidDate = Date.from(LocalDate.now()
                .minusYears(60)
                .atStartOfDay()
                .toInstant(ZoneOffset.UTC));

        Long peopleAbleToRetairement = 0L;

        for (Person person : people) {
            Date birthDate = person.getBirthDate();

            if (person.getSex().equals("M")) {
                if (birthDate.before(maleValidDate)) {
                    peopleAbleToRetairement++;
                }
            } else {
                if (birthDate.before(femaleValidDate))
                    peopleAbleToRetairement++;
            }
        }
        return peopleAbleToRetairement;
    }

    public static boolean isNotFromTheFuture(Date birthDay) {
        Date presentDate = Date.from(LocalDate.now()
                .atStartOfDay()
                .toInstant(ZoneOffset.UTC));
        return (!birthDay.after(presentDate));
    }

    public static boolean isAdult(Date birthDay) {
        Date validateAdultDate = Date.from(LocalDate.now()
                .minusYears(18)
                .atStartOfDay()
                .toInstant(ZoneOffset.UTC));
        return birthDay.before(validateAdultDate);
    }

    public static List<Animal> haveAnimal(Long id, List<Animal> animals) {
        List<Animal> personAnimals = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getId().equals(id)) {
                personAnimals.add(animal);
            }
        } return personAnimals;
    }
}