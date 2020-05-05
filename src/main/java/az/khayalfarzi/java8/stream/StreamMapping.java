package az.khayalfarzi.java8.stream;

import az.khayalfarzi.java8.locale.entity.Person;
import az.khayalfarzi.java8.locale.repository.PersonRepo;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.mapping;


public class StreamMapping {

    static List<String> mappingNameList() {
        return PersonRepo.getAll()
                .stream()
                .collect(mapping(Person::getName, Collectors.toList()));
    }

    static Set<String> mappingNameSet() {
        return PersonRepo.getAll()
                .stream()
                .collect(mapping(Person::getName, Collectors.toSet()));
    }

    static long countingMalePerson() {
        return PersonRepo.getAll()
                .stream()
                .filter(person -> person.getGender().equals("Male"))
                .map(Person::getAge)
                .collect(counting());
    }

    public static void main(String[] args) {

        mappingNameList().forEach(System.out::println);

        mappingNameSet().forEach(System.out::println);

        System.out.println(countingMalePerson());
    }
}
