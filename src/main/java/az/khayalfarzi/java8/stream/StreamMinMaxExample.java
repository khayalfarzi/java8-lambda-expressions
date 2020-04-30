package az.khayalfarzi.java8.stream;

import az.khayalfarzi.java8.locale.entity.Person;
import az.khayalfarzi.java8.locale.repository.PersonRepo;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamMinMaxExample {

    static Optional<Person> getOldPerson() {
        return PersonRepo
                .getAll()
                .stream()
                .max(Comparator.comparing(Person::getAge));
    }

    static Optional<Person> getYoungPerson() {
        return PersonRepo
                .getAll()
                .stream()
                .min(Comparator.comparing(Person::getAge));
    }

    static List<Person> filterMultiplePerson() {
        return PersonRepo
                .getAll()
                .stream()
                .filter(person -> person.getAge() ==
                        getOldPerson().get().getAge())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        System.out.println(getOldPerson());

        System.out.println(getYoungPerson());

        System.out.println(filterMultiplePerson());
    }
}