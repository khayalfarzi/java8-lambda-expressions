package az.khayalfarzi.java8.stream;

import az.khayalfarzi.java8.locale.entity.Person;
import az.khayalfarzi.java8.locale.repository.PersonRepo;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.partitioningBy;

public class StreamPartitioning {

    private static void getOldPerson() {
        Map<Boolean, List<Person>> map = PersonRepo.getAll()
                .stream()
                .collect(partitioningBy(person -> person.getAge() > 50));
        Stream.of(map).forEach(System.out::println);
    }

    private static void getOldPersonWith2Param() {
        Map<Boolean, Set<Person>> map = PersonRepo.getAll()
                .stream()
                .collect(partitioningBy(person -> person.getAge() > 50,
                        Collectors.toSet()));
        Stream.of(map).forEach(System.out::println);
    }

    private static void getOldPersonWithMap() {
        Map<Boolean,
                Map<String,
                        List<String>>> map = PersonRepo.getAll()
                .stream()
                .collect(partitioningBy(person -> person.getAge() > 50,
                        Collectors.toMap(
                                Person::getName,
                                Person::getHobbies)));
        Stream.of(map).forEach(System.out::println);
    }

    public static void main(String[] args) {

        getOldPerson();

        getOldPersonWith2Param();

        getOldPersonWithMap();
    }
}
