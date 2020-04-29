package az.khayalfarzi.java8.stream;

import az.khayalfarzi.java8.locale.entity.Person;
import az.khayalfarzi.java8.locale.repository.PersonRepo;

import java.util.List;
import java.util.stream.Collectors;

public class StreamMap {

    static List<String> getNameOfPerson(List<Person> personList) {
        return personList
                .stream()
                .map(Person::getName)
                .map(String::toUpperCase)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        getNameOfPerson(PersonRepo.getAll());
    }
}
