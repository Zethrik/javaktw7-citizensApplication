package pl.sdacademy.citizens.model;

import pl.sdacademy.citizens.PeopleUtils;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Person {
    private Long id;
    private String name;
    private String lastName;
    private String sex;
    private Date birthDate;
    private List<Animal> ownedAnimals;

    private Person(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.sex = builder.sex;
        this.birthDate = builder.birthDate;
        this.ownedAnimals = builder.ownedAnimals;
    }

    public static Builder builder(CsvLine line) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return new Builder()
                .id(Long.parseLong(line.getElementAt(0)))
                .name(line.getElementAt(1))
                .lastName(line.getElementAt(2))
                .sex(line.getElementAt(3))
                .birthDate(dateFormat.parse(line.getElementAt(4)));
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSex() {
        return sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public static class Builder {
        private Long id;
        private String name;
        private String lastName;
        private String sex;
        private Date birthDate;
        private List<Animal> ownedAnimals;

        private Builder() {
            this.ownedAnimals = new ArrayList<>();
        }

        private Builder id(Long id) {
            this.id = id;
            return this;
        }

        private Builder name(String name) {
            this.name = name;
            return this;
        }

        private Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        private Builder sex(String sex) {
            this.sex = sex;
            return this;
        }

        private Builder birthDate(Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        private Builder ownedAnimals(Animal animal) {
            this.ownedAnimals.add(animal);
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    public static void addAnimal(Map<Long, Person> people, List<Animal> animals) {
        for (Animal animal : animals) {
            for (Long id : people.keySet()) {
                if (animal.getId().equals(id)) {
                    people.get(id).ownedAnimals.add(animal);
                }
            }
        }
    }
}