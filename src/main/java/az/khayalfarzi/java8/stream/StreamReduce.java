package az.khayalfarzi.java8.stream;

import az.khayalfarzi.java8.locale.entity.Person;
import az.khayalfarzi.java8.locale.repository.PersonRepo;

import java.util.Arrays;
import java.util.List;

public class StreamReduce {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(5, 4, 8, 9, 3, 7, 1, 2);

        System.out.println(
                integerList.stream()
                        .mapToInt(value -> value)
                        .sum());

        System.out.println(
                integerList.stream()
                        .mapToLong(value -> value)
                        .count());

        System.out.println(
                integerList.stream()
                        .reduce(1, (b, a) -> (a * b)));

        System.out.println(
                integerList.stream()
                        .reduce(0, Integer::max)
        );

        System.out.println(
                PersonRepo
                        .getAll()
                        .stream()
                        .map(Person::getName)
                        .reduce(String::concat)
        );

        System.out.println(
                PersonRepo
                        .getAll()
                        .stream()
                        .reduce((person, person2) ->
                                person.getSalary() > person2.getSalary() ? person : person2)
        );
    }
}
