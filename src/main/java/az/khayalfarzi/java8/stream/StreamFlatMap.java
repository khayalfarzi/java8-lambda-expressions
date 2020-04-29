package az.khayalfarzi.java8.stream;

import az.khayalfarzi.java8.locale.entity.Person;
import az.khayalfarzi.java8.locale.repository.PersonRepo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFlatMap {

    static List<String> getHobbiesFromList(List<Person> personList) {
        return personList
                .stream()
                .map(Person::getHobbies)
                .flatMap(Collection::stream)
                .distinct()
                .sorted()
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    static long countOfHobbies(List<Person> personList) {
        return personList
                .stream()
                .map(Person::getHobbies)
                .flatMap(Collection::stream)
                .distinct()
                .count();
    }

    public static void main(String[] args) {

        List<Integer> oddNumber = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> evenNumber = Arrays.asList(2, 4, 6, 8);
        List<List<Integer>> numbers = Arrays.asList(oddNumber, evenNumber);

        numbers.forEach(System.out::println);   //before flatmap

        numbers.stream()                        //after flatmap
                .flatMap(Collection::stream)
                .peek(System.out::println)
                .collect(Collectors.toList());

        getHobbiesFromList(PersonRepo.getAll());

        System.out.println(countOfHobbies(PersonRepo.getAll()));
    }
}
