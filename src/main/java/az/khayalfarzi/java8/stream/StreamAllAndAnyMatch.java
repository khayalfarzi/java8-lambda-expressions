package az.khayalfarzi.java8.stream;

import az.khayalfarzi.java8.locale.repository.PersonRepo;

import java.util.Arrays;
import java.util.List;

public class StreamAllAndAnyMatch {

    public static void main(String[] args) {

        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange", "Kiwi", "Pineapple");

        System.out.println(
                fruits.stream()
                        .allMatch(fruit -> fruit.length() > 6)
        );

        System.out.println(
                fruits.stream()
                        .anyMatch(fruit -> fruit.length() > 6)
        );

        System.out.println(
                PersonRepo
                        .getAll()
                        .stream()
                        .allMatch(person -> person.getAge() > 40)
        );

        System.out.println(
                PersonRepo
                        .getAll()
                        .stream()
                        .anyMatch(person -> person.getAge() > 40)
        );

    }
}
