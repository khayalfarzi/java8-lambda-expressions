package az.khayalfarzi.java8.stream;

import az.khayalfarzi.java8.locale.entity.Person;
import az.khayalfarzi.java8.locale.repository.PersonRepo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamVsCollection {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jim", "John", "Max");
        names.forEach(System.out::println);

        Stream<String> stream = names.stream();
        stream.forEach(System.out::println);

        List<String> personList =
                PersonRepo
                        .getAll()
                        .stream()
                        .peek(System.out::println)
                        .map(Person::getName)
                        .peek(System.out::println)
                        .collect(Collectors.toList());
    }
}
